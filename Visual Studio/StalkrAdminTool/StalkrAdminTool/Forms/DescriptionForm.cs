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

			enum_gender.SetValues(_description.Gender.EnumToStringList, _description.Gender);
			enum_sexuality.SetValues(_description.Sexuality.EnumToStringList, _description.Sexuality);
			enum_region.SetValues(_description.Area.EnumToStringList, _description.Area);
			enum_smoking.SetValues(_description.Smoking.EnumToStringList, _description.Smoking);
			enum_drinking.SetValues(_description.Drinking.EnumToStringList, _description.Drinking);
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
		private void num_age_ValueChanged(object sender, EventArgs e)
		{
			_altered[2] = true;
		}
		/*private void enum_gender_SelectionChanged(object sender, EventArgs e)
		{
			_altered[3] = true;
		}*/
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
			//if (_altered[0] == true) { _description.UniqueID = new Guid(txt_guid.Text); }
			//if (_altered[1] == true) { _description.TimeStamp = txt_timestamp.Text; }
			if (_altered[2] == true) { _description.Age = new Range(Convert.ToInt32(num_age.Value), Convert.ToInt32(num_agemax.Value)); }
			if (_altered[3] == true) { _description.Gender = enum_gender.Value; }
			if (_altered[4] == true) { _description.Sexuality = enum_sexuality.Value; }
			if (_altered[5] == true) { _description.Area = enum_region.Value; }
			if (_altered[6] == true) { _description.Smoking = enum_smoking.Value; }
			if (_altered[7] == true) { _description.Drinking = enum_drinking.Value; }

			this.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.Close();
		}
		#endregion
	}
}
