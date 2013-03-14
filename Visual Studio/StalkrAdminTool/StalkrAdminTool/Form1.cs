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
			dataGridView1.Columns.Add("username", "Username");
			dataGridView1.Columns.Add("displayname", "Displayed name");
			dataGridView1.Columns.Add("fullname", "Full name");

			foreach (User u in result)
			{
				dataGridView1.Rows.Add(u.Name.UserName, u.Name.DisplayName, u.Name.FullName);
			}
		}
	}
}
