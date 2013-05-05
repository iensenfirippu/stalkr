using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace StalkrAdminTool
{
	public partial class UserForm : Form
	{
		#region Class constants

		private static String DELETEWARNINGTITLE = "Please confirm";
		private static String DELETEWARNINGMESSAGE = "You are about to delete a preference object. This action will be immediately carried out by the database, and the data will be unrecoverable.\nAre you sure you want to delete this object?";

		#endregion

		#region Class global variables

		private WSconnect _db;
		private User _user;

		#endregion

		// Contructor
		public UserForm(User user)
		{
			InitializeComponent();

			_db = WSconnect.Instance;
			DateTime now = DateTime.Now;
			date_birth.MinDate = new DateTime(now.Year - 99, now.Month, now.Day);
			date_birth.MaxDate = new DateTime(now.Year - 18, now.Month, now.Day);

			if (user == null) { _user = new User(); }
			else { _user = user; }

			txt_guid.Text = _user.UniqueID.ToString().ToUpper();
			txt_email.Text = _user.Email;
			txt_user.Text = _user.Username;
			txt_pass.Text = _user.Password;
			txt_firstname.Text = _user.FirstName;
			txt_lastname.Text = _user.LastName;
			if (_user.Birthday > date_birth.MaxDate || _user.Birthday < date_birth.MinDate)
			{
				date_birth.Value = date_birth.MaxDate;
			}
			else
			{
				date_birth.Value = _user.Birthday;
			}

			if (_user.Location != null)
			{
				num_lat.Value = Convert.ToDecimal(_user.Location.Latitude);
				num_lon.Value = Convert.ToDecimal(_user.Location.Longitude);
				date_location.Value = _user.Location.TimeStamp;
			}

			if (_user.Description != null)
			{
				txt_description.Text = "Description object";
				btn_desc_add.Enabled = false;
				btn_desc_del.Enabled = false;
				btn_desc_edit.Enabled = true;
			}
			else
			{
				btn_desc_add.Enabled = true;
				btn_desc_del.Enabled = false;
				btn_desc_edit.Enabled = false;
			}
		}

		#region Properties

		public User ReturnValue
		{
			get { return _user; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Draws or Re-draws the preference dropdown
		/// </summary>
		public void RedrawPreferences()
		{
			// Clear out old elements
			drop_preference.Items.Clear();
			if (_user.Preferences.Count > 0)
			{
				foreach (Description pref in _user.Preferences)
				{
					drop_preference.Items.Add(pref);
				}
				drop_preference.SelectedIndex = 0;
				btn_pref_add.Enabled = true;
				if (_user.Preferences.Count > 1) { btn_pref_del.Enabled = true; }
				else { btn_pref_del.Enabled = false; }
				btn_pref_edit.Enabled = true;
			}
			else
			{
				btn_pref_add.Enabled = true;
				btn_pref_del.Enabled = false;
				btn_pref_edit.Enabled = false;
			}
		}

		#endregion

		#region Events

		private void UserForm_Load(object sender, EventArgs e)
		{
			RedrawPreferences();
		}

		private void date_birth_ValueChanged(object sender, EventArgs e)
		{
			if (_user != null)
			{
				_user.Description.Age.Set(DateTime.Now.Year - date_birth.Value.Year);
			}
		}

		private void btn_desc_add_Click(object sender, EventArgs e)
		{
			// Never enabled, doesn't do anything
		}

		private void btn_desc_del_Click(object sender, EventArgs e)
		{
			// Never enabled, doesn't do anything
		}

		private void btn_desc_edit_Click(object sender, EventArgs e)
		{
			DescriptionForm form = new DescriptionForm(_user.Description, false);
			form.ShowDialog();
		}

		private void btn_pref_add_Click(object sender, EventArgs e)
		{
			Description pref = new Description();
			DescriptionForm form = new DescriptionForm(pref, true);
			DialogResult dr = form.ShowDialog();

			if (dr == System.Windows.Forms.DialogResult.OK)
			{
				_user.Preferences.Add(pref);
				//DBINSERT
				RedrawPreferences();
			}
		}

		private void btn_pref_del_Click(object sender, EventArgs e)
		{
			if (_user.Preferences.Count > 1)
			{
				DialogResult dr = System.Windows.Forms.MessageBox.Show(DELETEWARNINGMESSAGE, DELETEWARNINGTITLE, MessageBoxButtons.YesNo, MessageBoxIcon.Warning);

				if (dr == System.Windows.Forms.DialogResult.Yes)
				{
					_user.Preferences.RemoveAt(drop_preference.SelectedIndex);
					//DBDELETE
					RedrawPreferences();
				}
			}
		}

		private void btn_pref_edit_Click(object sender, EventArgs e)
		{
			DescriptionForm form = new DescriptionForm(_user.Preferences[drop_preference.SelectedIndex], true);
			form.ShowDialog();
		}

		private void button_cancel_Click(object sender, EventArgs e)
		{
			this.DialogResult = System.Windows.Forms.DialogResult.Cancel;

			this.Close();
		}

		private void button_save_Click(object sender, EventArgs e)
		{
			_user.Email = txt_email.Text;
			_user.Username = txt_user.Text;
			_user.Password = txt_pass.Text;
			_user.FirstName = txt_firstname.Text;
			_user.LastName = txt_lastname.Text;
			_user.Birthday = date_birth.Value;
			
			float lat = Convert.ToSingle(num_lat.Value);
			float lon = Convert.ToSingle(num_lon.Value);
			if (lat != _user.Location.Latitude || lon != _user.Location.Longitude)
			{
				_user.Location = new GeoLocation(lat, lon);
			}

			if (Tools.ValidateUserString(Tools.UserToString(_user, false)) >= 0.2f)
			{
				string response = _db.SaveUser(_user);

				if (response.Equals("E10"))
				{
					this.DialogResult = System.Windows.Forms.DialogResult.OK;
					this.Close();
				}
				else
				{
					System.Console.Beep(10000, 1000);
					System.Console.Out.WriteLine(response);
				}
			}
			else
			{
				System.Windows.Forms.MessageBox.Show(Tools.UserToString(_user, false), "Validation failed", MessageBoxButtons.OK, MessageBoxIcon.Information);
			}
		}

		#endregion
	}
}
