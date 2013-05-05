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
		//private Boolean _ispreference;

		// Contructor
		public DescriptionForm(Description description, Boolean ispreference)
		{
			InitializeComponent();

			_description = description;

			txt_guid.Text = _description.UniqueID.ToString().ToUpper();
			txt_timestamp.Text = _description.TimeStamp.ToLongTimeString();
			if (ispreference) { txt_title.Text = _description.Title; }
			else { txt_title.Enabled = false; } 
			num_age.Value = _description.Age;
			if (ispreference) { num_agemax.Value = _description.Age.Max; }
			else { num_age.Enabled = false; num_agemax.Enabled = false; }

			enum_gender.SetValues(_description.Gender.EnumToStringList, _description.Gender, ispreference);
			enum_sexuality.SetValues(_description.Sexuality.EnumToStringList, _description.Sexuality, ispreference);
			enum_region.SetValues(_description.Area.EnumToStringList, _description.Area, ispreference);
			enum_smoking.SetValues(_description.Smoking.EnumToStringList, _description.Smoking, ispreference);
			enum_drinking.SetValues(_description.Drinking.EnumToStringList, _description.Drinking, ispreference);
		}

		// Properties
		public Description ReturnValue
		{
			get { return _description; }
		}

		#region Form buttons
		private void button_cancel_Click(object sender, EventArgs e)
		{
			this.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.Close();
		}
		private void button_save_Click(object sender, EventArgs e)
		{
			//_description.UniqueID = new Guid(txt_guid.Text);
			_description.TimeStamp = DateTime.Now;
			_description.Title = txt_title.Text;
			if (num_agemax.Value == 0) { _description.SetAge(Convert.ToInt32(num_age.Value)); }
			else { _description.SetAge(Convert.ToInt32(num_age.Value), Convert.ToInt32(num_agemax.Value)); }
			_description.Gender = enum_gender.Value;
			_description.Sexuality = enum_sexuality.Value;
			_description.Area = enum_region.Value;
			_description.Smoking = enum_smoking.Value;
			_description.Drinking = enum_drinking.Value;

			this.DialogResult = System.Windows.Forms.DialogResult.OK;
			this.Close();
		}
		#endregion
	}
}
