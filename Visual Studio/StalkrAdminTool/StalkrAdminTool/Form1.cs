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
	public partial class Form1 : Form
	{
		public Form1()
		{
			InitializeComponent();

			DBConnect db = new DBConnect();
			List<User> result = db.SelectAllUsers();

			if (result.Count > 0)
			{
				toolStripStatusLabel1.Text = result.Count + " user objects successfully loaded from database";
			}
			else
			{
				toolStripStatusLabel1.Text = "Couldn't loaded from database";
			}

			dataGridView1.Columns.Add("username", "Username");
			dataGridView1.Columns.Add("displayname", "Displayed name");
			dataGridView1.Columns.Add("fullname", "Full name");

			foreach (User u in result)
			{
				dataGridView1.Rows.Add(u.Name.UserName, u.Name.DisplayName, u.Name.FullName);
			}
		}

		private void dataGridView1_MouseClick(object sender, MouseEventArgs e)
		{
			if (e.Clicks == 2)
			{
				//start edit form
			}
			if (e.Button == System.Windows.Forms.MouseButtons.Right)
			{
				contextMenuStrip1.Show(Cursor.Position);
			}
		}

		private void createNewUserToolStripMenuItem_MouseUp(object sender, MouseEventArgs e)
		{

		}

		private void deleteThisUserToolStripMenuItem_MouseUp(object sender, MouseEventArgs e)
		{

		}

		private void editThisUserToolStripMenuItem_MouseUp(object sender, MouseEventArgs e)
		{

		}
	}
}
