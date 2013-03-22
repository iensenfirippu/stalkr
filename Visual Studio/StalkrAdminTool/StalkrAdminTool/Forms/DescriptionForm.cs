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
	public partial class DescriptionForm : Form
	{
		// Class global variables
		private Description _description;
		private bool[] _altered;

		// Contructor
		public DescriptionForm(Description description)
		{
			InitializeComponent();
			_description = description;
			_altered = new bool[] { false, false, false, false, false, false, false, false };

			txt_guid.Text = _description.UniqueID.ToString().ToUpper();
			txt_timestamp.Text = _description.TimeStamp.ToLongTimeString();
			num_age.Value = _description.Age;
			num_agemax.Value = _description.Age.Max;
			object[] temp = { null, null, null, null, null, null };
			int index = 0;
			foreach (GenderType e in Enum.GetValues(typeof(GenderType)))
			{
				if (_description.Gender.Contains(e)) { temp[index] = true; } else { temp[index] = false; }
				temp[index + 1] = e;
				index += 2;

				if (temp[5] != null)
				{
					_description.Age
					dataGridView1.Rows.Add(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
					for (int i = 0; i < 6; i++) { temp[i] = null; }
					index = 0;
				}
			}
			dataGridView1.Rows.Add(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
			for (int i = 0; i < 6; i++) { temp[i] = null; }
			index = 0;
			foreach (SexualityType e in Enum.GetValues(typeof(SexualityType)))
			{
				if (_description.Sexuality.Contains(e)) { chk_orientation.Items.Add(e, true); }
				else { chk_orientation.Items.Add(e, false); }
			}
			foreach (AreaType e in Enum.GetValues(typeof(AreaType)))
			{
				if (_description.Area.Contains(e)) { chk_region.Items.Add(e, true); }
				else { chk_region.Items.Add(e, false); }
			}
			foreach (SmokingType e in Enum.GetValues(typeof(SmokingType)))
			{
				if (_description.Smoking.Contains(e)) { chk_smoking.Items.Add(e, true); }
				else { chk_smoking.Items.Add(e, false); }
			}
			foreach (DrinkingType e in Enum.GetValues(typeof(DrinkingType)))
			{
				if (_description.Drinking.Contains(e)) { chk_drinking.Items.Add(e, true); }
				else { chk_drinking.Items.Add(e, false); }
			}
		}

		// Properties
		public Description ReturnValue
		{
			get { return _description; }
		}

		// Methods
		public void ValueChanged(int index)
		{
			_altered[index] = true;
		}

		#region Methods for the inputfields of the form
		private void txt_email_TextChanged(object sender, EventArgs e)
		{
			_altered[1] = true;
		}
		private void txt_user_TextChanged(object sender, EventArgs e)
		{
			_altered[2] = true;
		}
		private void txt_pass_TextChanged(object sender, EventArgs e)
		{
			_altered[3] = true;
		}
		private void txt_name_TextChanged(object sender, EventArgs e)
		{
			_altered[4] = true;
		}
		private void txt_display_TextChanged(object sender, EventArgs e)
		{
			_altered[5] = true;
		}
		private void date_birth_ValueChanged(object sender, EventArgs e)
		{
			_altered[6] = true;
		}
		private void txt_location_TextChanged(object sender, EventArgs e)
		{
			_altered[7] = true;
		}
		private void date_location_ValueChanged(object sender, EventArgs e)
		{
			_altered[7] = true;
		}
		#endregion
		#region Methods for description and preference buttons
		private void btn_desc_add_Click(object sender, EventArgs e)
		{
			_altered[8] = true;
		}
		private void btn_desc_del_Click(object sender, EventArgs e)
		{
			_altered[8] = true;
		}
		private void btn_desc_edit_Click(object sender, EventArgs e)
		{
			_altered[8] = true;
		}
		private void btn_pref_add_Click(object sender, EventArgs e)
		{
			_altered[9] = true;
		}
		private void btn_pref_del_Click(object sender, EventArgs e)
		{
			_altered[9] = true;
		}
		private void btn_pref_edit_Click(object sender, EventArgs e)
		{
			_altered[9] = true;
		}
		#endregion
		#region Form buttons
		private void button_cancel_Click(object sender, EventArgs e)
		{
			//_user = null;
			this.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.Close();
		}
		private void button_save_Click(object sender, EventArgs e)
		{
			//if (_altered[0] == true) { _user.UniqueID = new Guid(txt_guid.Text); }
			/*if (_altered[1] == true) { _user.Email = txt_email.Text; }
			if (_altered[2] == true) { _user.Name.UserName = txt_user.Text; }
			if (_altered[3] == true) { _user.Password = txt_pass.Text; }
			if (_altered[4] == true) {
				_user.Name.FirstName = txt_firstname.Text;
				_user.Name.LastName = txt_lastname.Text;
			}
			if (_altered[5] == true) { _user.Name.DisplayName = txt_display.Text; }
			if (_altered[6] == true) { _user.Birthdate = date_birth.Value; }
			if (_altered[7] == true) { _user.Location = new GeoLocation(Convert.ToSingle(txt_lat.Text), Convert.ToSingle(txt_lon.Text), date_location.Value);  }
			//if (_altered[8] == true) { _user.Description = _user.Description; }*/
			//if (_altered[8] == true) { _user.Preferences = _user.Preferences; }

			this.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.Close();
		}
		#endregion
	}
}
