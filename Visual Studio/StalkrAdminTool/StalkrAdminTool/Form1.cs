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
		// Class local variables
		List<User> userlist;

		private static string CLOSEWARNING = "Your software is soon to close, if not safe data you lose. pwease be careful wiff yuz dataz.\nPress affirmative to okay, false to not okay.";
		private static string CLOSETITLE = "You are about to close...";

		// Constructor
		public Form1()
		{
			InitializeComponent();

			DBConnect db = new DBConnect();
			userlist = db.SelectAllUsers();

			if (userlist.Count > 0)
			{
				toolStripStatusLabel1.Text = userlist.Count + " user objects successfully loaded from database";
			}
			else
			{
				toolStripStatusLabel1.Text = "Couldn't loaded from database";
			}

			DrawUserTable();
		}

		/// <summary>
		/// Draws a table of all the users
		/// </summary>
		private void DrawUserTable()
		{
			// Clear old table
			dataGridView1.Columns.Clear();
			dataGridView1.Rows.Clear();

			// Create new table columns
			dataGridView1.Columns.Add("guid", "Guid");
			dataGridView1.Columns.Add("username", "Username");
			dataGridView1.Columns.Add("displayname", "Displayed name");
			dataGridView1.Columns.Add("fullname", "Full name");
			dataGridView1.Columns.Add("birthday", "Birthday");

			// Fill out the table rows
			foreach (User u in userlist)
			{
				dataGridView1.Rows.Add(u.UniqueID.ToString(), u.Name.UserName, u.Name.DisplayName, u.Name.FullName, u.Birthdate.ToShortDateString());
			}
		}

		// Event fired when the gridview is being clicked
		private void dataGridView1_MouseClick(object sender, MouseEventArgs e)
		{
			// On right click, show a contextmenu with edit, add, delete type options
			if (e.Button == System.Windows.Forms.MouseButtons.Right)
			{
				contextMenuStrip1.Show(Cursor.Position);
			}
		}

		// Event fired when the gridview is being clicked
		private void dataGridView1_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
		{
			// Edit user shortcut
			StartEditUserForm();
		}

		// Event fired when the "Create User" option is pressed
		private void createNewUserToolStripMenuItem_MouseUp(object sender, MouseEventArgs e)
		{
			// TODO: Start the "Edit User" form with an empty user object
			userlist.Add(new User());
			DrawUserTable();
		}

		// Event fired when the "Delete User" option is pressed
		private void deleteThisUserToolStripMenuItem_MouseUp(object sender, MouseEventArgs e)
		{
			// TODO: delete the selected user
		}

		// Event fired when the "Edit User" option is pressed
		private void editThisUserToolStripMenuItem_MouseUp(object sender, MouseEventArgs e)
		{
			StartEditUserForm();
		}

		// Self-explanatory...
		private void StartEditUserForm()
		{
			// TODO: if the table has been sorted the id's no longer match, propose to disable sorting, or use Guid field (possibly hidden)

			// Finds the selected index from the gridview
			int selectedindex = dataGridView1.SelectedRows[0].Index;
			User user = userlist[selectedindex];

			// Open the "Edit User" form with the corresponding user object in the list
			UserForm userform = new UserForm(user);
			userform.ShowDialog();
		}

		// Event fired when the "Exit" option is pressed
		private void aboutToolStripMenuItem1_Click(object sender, EventArgs e)
		{
			// TODO: show a proper about box
			System.Windows.Forms.MessageBox.Show("This is an internal tool for managing the database of the Android app Codenamed \"Stalkr\"\nIt is to be used only by the creators themselves.", "About", MessageBoxButtons.OK, MessageBoxIcon.Information);
		}

		// Event fired when the "About" option is pressed
		private void exitToolStripMenuItem_Click(object sender, EventArgs e)
		{
			this.Close();
		}

		// Event fired when the program is about to close
		private void Form1_FormClosing(object sender, FormClosingEventArgs e)
		{
			// Ask the user to acknowledge the shutdown
			DialogResult dr = System.Windows.Forms.MessageBox.Show(Form1.CLOSEWARNING, Form1.CLOSETITLE, MessageBoxButtons.OKCancel, MessageBoxIcon.Warning);

			if (dr != DialogResult.OK)
			{
				e.Cancel = true;
			}
		}
	}
}
