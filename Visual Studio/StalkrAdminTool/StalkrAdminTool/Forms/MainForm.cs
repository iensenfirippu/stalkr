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
	public partial class MainForm : Form
	{
		#region Class constants

		//private static string CLOSEWARNING = "Your software is soon to close, if not safe data you lose. pwease be careful wiff yuz dataz.\nPress affirmative to okay, false to not okay.";
		//private static string CLOSETITLE = "You are about to close...";
		private static string DELETEWARNING = "You are about to permanently delete the user \"{0}\".\nOnce deleted the user account cannot be recovered.\n\nAre you really sure you want to do this?";
		private static string DELETETITLE = "USER DELETION";
		private static string LOADSUCCESS = "{0} user objects successfully loaded from database";
		private static string LOADFAIL = "Couldn't connect to database";
		private static string USEROK = "User object successfully changed";
		private static string USERCANCEL = "User edit was cancelled";
		private static string NOSELECTEDUSER = "No user object selected, please select or create a user object and try again.";

		#endregion

		// Class local variables
		private WSconnect _db;

		private List<User> _userlist;

		// Constructor
		public MainForm()
		{
			InitializeComponent();

			_db = WSconnect.Instance;
			permissions_label.Text = _db.Permission;
			
			LoadUsers(true);
		}

		#region Methods

		/// <summary>
		/// Loads all the users from the database
		/// </summary>
		private void LoadUsers(bool report)
		{
			_userlist = _db.GetUsers(Guid.Empty);

			if (report)
			{
				if (_userlist.Count > 0)
				{
					status_label.Text = LOADSUCCESS.Replace("{0}", _userlist.Count.ToString());
				}
				else
				{
					status_label.Text = LOADFAIL;
				}
			}

			DrawUserTable();
		}

		/// <summary>
		/// Draws a table of all the users
		/// </summary>
		private void DrawUserTable()
		{
			// Clear old table
			dgv_main.Columns.Clear();
			dgv_main.Rows.Clear();

			// Create new table columns
			dgv_main.Columns.Add("guid", "Guid");
			dgv_main.Columns[0].Visible = false;
			dgv_main.Columns.Add("username", "Username");
			dgv_main.Columns.Add("fullname", "Full name");
			dgv_main.Columns.Add("birthday", "Birthday");
			dgv_main.Columns.Add("prefernces", "# of preferences");

			// Fill out the table rows
			foreach (User u in _userlist)
			{
				dgv_main.Rows.Add(null, u.Username, u.FullName, u.Birthday.ToShortDateString(), u.Preferences.Count);
				dgv_main.Rows[dgv_main.Rows.Count - 1].Cells[0].Value = u.UniqueID;
			}
		}

		// Self-explanatory...
		private void StartEditUserForm(User user)
		{
			// Open the "Edit User" form with the corresponding user object in the list
			UserForm userform = new UserForm(user);

			DialogResult dr = userform.ShowDialog();

			if (dr == DialogResult.OK)
			{
				status_label.Text = USEROK;
			}
			else
			{
				status_label.Text = USERCANCEL;
			}

			LoadUsers(false);
		}

		/// <summary>
		/// Fetches the User object that is selected in the DataGridView
		/// </summary>
		/// <returns>A user object</returns>
		private User GetSelectedUserObject()
		{
			try
			{
				// Finds the desired user object from the selected index in the gridview
				Guid userid = (Guid)dgv_main.SelectedRows[0].Cells[0].Value;
				User user = null;
				for (int i = 0; i < _userlist.Count; i++)
				{
					if (_userlist[i].UniqueID == userid)
					{
						user = _userlist[i];
						i = _userlist.Count;
					}
				}
				return user;
			}
			catch (Exception)
			{
				return null;
			}
		}

		#endregion

		#region Events

		// Event fired when the gridview is being clicked
		private void dataGridView1_MouseClick(object sender, MouseEventArgs e)
		{
			// On right click, show a contextmenu with edit, add, delete type options
			if (e.Button == System.Windows.Forms.MouseButtons.Right)
			{
				context_gridview.Show(Cursor.Position);
			}
		}

		// Event fired when the gridview is being clicked
		private void dataGridView1_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
		{
			// Edit user shortcut
			StartEditUserForm(GetSelectedUserObject());
		}

		// Event fired when the "Create User" option is pressed
		private void createNewUserToolStripMenuItem_MouseUp(object sender, MouseEventArgs e)
		{
			//_userlist.Add(new User());
			//DrawUserTable();
			//dgv_main.Rows[dgv_main.Rows.Count - 1].Selected = true;
			StartEditUserForm(null);
		}

		// Event fired when the "Delete User" option is pressed
		private void deleteThisUserToolStripMenuItem_MouseUp(object sender, MouseEventArgs e)
		{
			// Deletes the selected user from the userlist and reloads the gridview
			User user = GetSelectedUserObject();
			if (user != null)
			{
				DialogResult dr = MessageBox.Show(DELETEWARNING.Replace("{0}", user.Username), DELETETITLE, MessageBoxButtons.OKCancel, MessageBoxIcon.Stop);
				if (dr == DialogResult.OK)
				{
					string result = _db.DeleteUser(user.UniqueID);

					//TODO: handle errorcodes for delete

					LoadUsers(false);
				}
			}
			else
			{
				status_label.Text = NOSELECTEDUSER;
			}
		}

		// Event fired when the "Edit User" option is pressed
		private void editThisUserToolStripMenuItem_MouseUp(object sender, MouseEventArgs e)
		{
			StartEditUserForm(GetSelectedUserObject());
		}

		// Event fired when the "About" option is pressed
		private void aboutToolStripMenuItem1_Click(object sender, EventArgs e)
		{
			AboutBox aboutbox = new AboutBox();
			aboutbox.ShowDialog();
		}

		// Event fired when the "Reload" option is pressed
		private void reloadToolStripMenuItem_Click(object sender, EventArgs e)
		{
			LoadUsers(true);
		}

		// Event fired when the "Random" option is pressed
		private void createRandomUserToolStripMenuItem_Click(object sender, EventArgs e)
		{
			RandomForm window = new RandomForm();
			window.ShowDialog();

			LoadUsers(false);
		}

		// Event fired when the "Exit" option is pressed
		private void exitToolStripMenuItem_Click(object sender, EventArgs e)
		{
			this.Close();
		}

		// Event fired when the program is about to close
		private void Form1_FormClosing(object sender, FormClosingEventArgs e)
		{
			// Ask the user to acknowledge the shutdown
			//DialogResult dr = System.Windows.Forms.MessageBox.Show(MainForm.CLOSEWARNING, MainForm.CLOSETITLE, MessageBoxButtons.OKCancel, MessageBoxIcon.Warning);

			//if (dr != DialogResult.OK)
			//{
			//	e.Cancel = true;
			//}
		}

		// Event fired when the status label's text is changed
		private void status_label_TextChanged(object sender, EventArgs e)
		{
			if (status_label.Text != "")
			{
				// Starts the timer (to clear the message after a tick has passed)
				status_timer.Start();
			}
		}

		// Event fired every time the timer has "waited" a set amount of time
		private void status_timer_Tick(object sender, EventArgs e)
		{
			// clear the status label
			status_label.Text = "";
			// stop and reset the timer
			status_timer.Stop();
		}

		#endregion
	}
}
