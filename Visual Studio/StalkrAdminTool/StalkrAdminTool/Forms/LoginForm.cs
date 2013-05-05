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
	public partial class LoginForm : Form
	{
		// Class local variables
		private WSconnect _db;

		// Constructor
		public LoginForm()
		{
			InitializeComponent();

			_db = WSconnect.Instance;

			txt_username.Text = "Philip";
			txt_password.Text = "admin1234";
		}

		// Method
		private void btn_login_Click(object sender, EventArgs e)
		{
			btn_login.Enabled = false;
			bool success = false;

			if (!txt_username.Text.Equals("") && !txt_password.Text.Equals(""))
			{
				_db.Login(txt_username.Text, txt_password.Text);

				if (!_db.Permission.Equals("000000")) { success = true; }
			}

			if (success)
			{
				this.DialogResult = System.Windows.Forms.DialogResult.OK;
				this.Close();
			}
			else
			{
				btn_login.Enabled = true;
			}
		}
	}
}
