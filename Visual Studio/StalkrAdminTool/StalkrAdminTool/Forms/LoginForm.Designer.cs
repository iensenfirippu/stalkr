namespace StalkrAdminTool
{
	partial class LoginForm
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.IContainer components = null;

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose(bool disposing)
		{
			if (disposing && (components != null))
			{
				components.Dispose();
			}
			base.Dispose(disposing);
		}

		#region Windows Form Designer generated code

		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(LoginForm));
			this.pct_stalkr = new System.Windows.Forms.PictureBox();
			this.btn_login = new System.Windows.Forms.Button();
			this.lbl_username = new System.Windows.Forms.Label();
			this.txt_username = new System.Windows.Forms.TextBox();
			this.txt_password = new System.Windows.Forms.TextBox();
			this.lbl_password = new System.Windows.Forms.Label();
			this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
			((System.ComponentModel.ISupportInitialize)(this.pct_stalkr)).BeginInit();
			this.tableLayoutPanel1.SuspendLayout();
			this.SuspendLayout();
			// 
			// pct_stalkr
			// 
			this.pct_stalkr.Dock = System.Windows.Forms.DockStyle.Top;
			this.pct_stalkr.Image = global::StalkrAdminTool.Properties.Resources.spy;
			this.pct_stalkr.Location = new System.Drawing.Point(0, 0);
			this.pct_stalkr.Name = "pct_stalkr";
			this.pct_stalkr.Size = new System.Drawing.Size(242, 150);
			this.pct_stalkr.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage;
			this.pct_stalkr.TabIndex = 0;
			this.pct_stalkr.TabStop = false;
			// 
			// btn_login
			// 
			this.tableLayoutPanel1.SetColumnSpan(this.btn_login, 2);
			this.btn_login.Dock = System.Windows.Forms.DockStyle.Fill;
			this.btn_login.Location = new System.Drawing.Point(3, 55);
			this.btn_login.Name = "btn_login";
			this.btn_login.Size = new System.Drawing.Size(236, 20);
			this.btn_login.TabIndex = 1;
			this.btn_login.Text = "Login";
			this.btn_login.UseVisualStyleBackColor = true;
			this.btn_login.Click += new System.EventHandler(this.btn_login_Click);
			// 
			// lbl_username
			// 
			this.lbl_username.AutoSize = true;
			this.lbl_username.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_username.Location = new System.Drawing.Point(3, 0);
			this.lbl_username.Name = "lbl_username";
			this.lbl_username.Size = new System.Drawing.Size(59, 26);
			this.lbl_username.TabIndex = 2;
			this.lbl_username.Text = "Username";
			this.lbl_username.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// txt_username
			// 
			this.txt_username.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_username.Location = new System.Drawing.Point(68, 3);
			this.txt_username.Name = "txt_username";
			this.txt_username.Size = new System.Drawing.Size(171, 20);
			this.txt_username.TabIndex = 3;
			// 
			// txt_password
			// 
			this.txt_password.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_password.Location = new System.Drawing.Point(68, 29);
			this.txt_password.Name = "txt_password";
			this.txt_password.Size = new System.Drawing.Size(171, 20);
			this.txt_password.TabIndex = 5;
			// 
			// lbl_password
			// 
			this.lbl_password.AutoSize = true;
			this.lbl_password.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_password.Location = new System.Drawing.Point(3, 26);
			this.lbl_password.Name = "lbl_password";
			this.lbl_password.Size = new System.Drawing.Size(59, 26);
			this.lbl_password.TabIndex = 4;
			this.lbl_password.Text = "Password";
			this.lbl_password.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// tableLayoutPanel1
			// 
			this.tableLayoutPanel1.ColumnCount = 2;
			this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 65F));
			this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle());
			this.tableLayoutPanel1.Controls.Add(this.lbl_username, 0, 0);
			this.tableLayoutPanel1.Controls.Add(this.txt_password, 1, 1);
			this.tableLayoutPanel1.Controls.Add(this.lbl_password, 0, 1);
			this.tableLayoutPanel1.Controls.Add(this.txt_username, 1, 0);
			this.tableLayoutPanel1.Controls.Add(this.btn_login, 0, 2);
			this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Fill;
			this.tableLayoutPanel1.Location = new System.Drawing.Point(0, 150);
			this.tableLayoutPanel1.Name = "tableLayoutPanel1";
			this.tableLayoutPanel1.RowCount = 3;
			this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
			this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
			this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 33.33333F));
			this.tableLayoutPanel1.Size = new System.Drawing.Size(242, 78);
			this.tableLayoutPanel1.TabIndex = 6;
			// 
			// LoginForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(242, 228);
			this.Controls.Add(this.tableLayoutPanel1);
			this.Controls.Add(this.pct_stalkr);
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.Name = "LoginForm";
			this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Hide;
			this.Text = "LoginForm";
			((System.ComponentModel.ISupportInitialize)(this.pct_stalkr)).EndInit();
			this.tableLayoutPanel1.ResumeLayout(false);
			this.tableLayoutPanel1.PerformLayout();
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.PictureBox pct_stalkr;
		private System.Windows.Forms.Button btn_login;
		private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
		private System.Windows.Forms.Label lbl_username;
		private System.Windows.Forms.TextBox txt_password;
		private System.Windows.Forms.Label lbl_password;
		private System.Windows.Forms.TextBox txt_username;
	}
}