using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace StalkrAdmin
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {

            String server = "10.139.109.96:8080";
            String database = "stalkr";
            String uid = "root";
            String password = "";
            string connectionString;
            connectionString = "SERVER=" + server + ";" + "DATABASE=" +
            database + ";" + "UID=" + uid + ";" + "PASSWORD=" + password + ";";

            MySqlConnection connection = new MySqlConnection(connectionString);
            textBox1.Text = connection.ConnectionString;
            //connection.Open();
            //string query = "SELECT username FROM user WHERE id = 1";
            //MySqlCommand cmd = new MySqlCommand(query, connection);
            //MySqlDataReader dataReader = cmd.ExecuteReader();

            //while (dataReader.Read())
            //{
            //    textBox1.Text = dataReader["username"] + "";
            //}

        }
    }
}
