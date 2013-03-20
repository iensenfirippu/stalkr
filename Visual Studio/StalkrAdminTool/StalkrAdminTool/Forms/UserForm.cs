﻿using System;
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
		// Class global variables
		private User _user;
		private bool[] _altered;

		// Contructor
		public UserForm(User user)
		{
			InitializeComponent();
			_user = user;
			_altered = new bool[] { false, false, false, false, false, false, false, false, false, false, false };

			txt_guid.Text = _user.UniqueID.ToString().ToUpper();
			txt_email.Text = _user.Email;
			txt_user.Text = _user.Name.UserName;
			txt_pass.Text = _user.Password;
			txt_firstname.Text = _user.Name.FirstName;
			txt_lastname.Text = _user.Name.LastName;
			txt_display.Text = _user.Name.DisplayName;
			date_birth.Value = _user.Birthdate;

			if (_user.Location != null)
			{
				num_lat.Value = Convert.ToDecimal(_user.Location.Latitude);
				num_lon.Value = Convert.ToDecimal(_user.Location.Longitude);
				date_location.Value = user.Location.TimeStamp;
			}

			if (_user.Description != null)
			{
				txt_description.Text = _user.Description.UniqueID.ToString().ToUpper();
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

			if (user.Preferences != null)
			{
				txt_preference.Text = user.Preferences.UniqueID.ToString().ToUpper();
				btn_pref_add.Enabled = false;
				btn_pref_del.Enabled = false;
				btn_pref_edit.Enabled = true;
			}
			else
			{
				btn_pref_add.Enabled = true;
				btn_pref_del.Enabled = false;
				btn_pref_edit.Enabled = false;
			}
		}

		// Properties
		public User ReturnValue
		{
			get { return _user; }
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
		private void num_location_ValueChanged(object sender, EventArgs e)
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

			DescriptionForm form = new DescriptionForm(_user.Description);
			form.ShowDialog();
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

			DescriptionForm form = new DescriptionForm(_user.Preferences);
			form.ShowDialog();
		}
		#endregion
		#region Form buttons
		private void button_cancel_Click(object sender, EventArgs e)
		{
			this.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.Close();
		}
		private void button_save_Click(object sender, EventArgs e)
		{
			//if (_altered[0] == true) { _user.UniqueID = new Guid(txt_guid.Text); }
			if (_altered[1] == true) { _user.Email = txt_email.Text; }
			if (_altered[2] == true) { _user.Name.UserName = txt_user.Text; }
			if (_altered[3] == true) { _user.Password = txt_pass.Text; }
			if (_altered[4] == true) {
				_user.Name.FirstName = txt_firstname.Text;
				_user.Name.LastName = txt_lastname.Text;
			}
			if (_altered[5] == true) { _user.Name.DisplayName = txt_display.Text; }
			if (_altered[6] == true) { _user.Birthdate = date_birth.Value; }
			if (_altered[7] == true) { _user.Location = new GeoLocation(Convert.ToSingle(num_lat.Value), Convert.ToSingle(num_lon.Value), date_location.Value);  }
			//if (_altered[8] == true) { _user.Description = _user.Description; }
			//if (_altered[8] == true) { _user.Preferences = _user.Preferences; }

			this.DialogResult = System.Windows.Forms.DialogResult.OK;
			this.Close();
		}
		#endregion
	}
}
