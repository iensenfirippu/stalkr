﻿namespace StalkrAdminTool
{
	partial class UserForm
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
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(UserForm));
			this.table_buttons = new System.Windows.Forms.TableLayoutPanel();
			this.button_save = new System.Windows.Forms.Button();
			this.button_cancel = new System.Windows.Forms.Button();
			this.txt_display = new System.Windows.Forms.TextBox();
			this.txt_pass = new System.Windows.Forms.TextBox();
			this.txt_user = new System.Windows.Forms.TextBox();
			this.lbl_display = new System.Windows.Forms.Label();
			this.lbl_name = new System.Windows.Forms.Label();
			this.lbl_pass = new System.Windows.Forms.Label();
			this.lbl_user = new System.Windows.Forms.Label();
			this.txt_guid = new System.Windows.Forms.TextBox();
			this.lbl_guid = new System.Windows.Forms.Label();
			this.lbl_email = new System.Windows.Forms.Label();
			this.txt_email = new System.Windows.Forms.TextBox();
			this.table_main = new System.Windows.Forms.TableLayoutPanel();
			this.tableLayoutPanel3 = new System.Windows.Forms.TableLayoutPanel();
			this.txt_preference = new System.Windows.Forms.TextBox();
			this.btn_pref_add = new System.Windows.Forms.Button();
			this.btn_pref_del = new System.Windows.Forms.Button();
			this.btn_pref_edit = new System.Windows.Forms.Button();
			this.tableLayoutPanel4 = new System.Windows.Forms.TableLayoutPanel();
			this.txt_description = new System.Windows.Forms.TextBox();
			this.btn_desc_add = new System.Windows.Forms.Button();
			this.btn_desc_del = new System.Windows.Forms.Button();
			this.btn_desc_edit = new System.Windows.Forms.Button();
			this.table_name = new System.Windows.Forms.TableLayoutPanel();
			this.txt_firstname = new System.Windows.Forms.TextBox();
			this.txt_lastname = new System.Windows.Forms.TextBox();
			this.lbl_birth = new System.Windows.Forms.Label();
			this.lbl_location = new System.Windows.Forms.Label();
			this.lbl_preference = new System.Windows.Forms.Label();
			this.lbl_description = new System.Windows.Forms.Label();
			this.lbl_locatime = new System.Windows.Forms.Label();
			this.table_location = new System.Windows.Forms.TableLayoutPanel();
			this.txt_lon = new System.Windows.Forms.TextBox();
			this.txt_lat = new System.Windows.Forms.TextBox();
			this.lbl_lat = new System.Windows.Forms.Label();
			this.lbl_lon = new System.Windows.Forms.Label();
			this.date_birth = new System.Windows.Forms.DateTimePicker();
			this.date_location = new System.Windows.Forms.DateTimePicker();
			this.table_buttons.SuspendLayout();
			this.table_main.SuspendLayout();
			this.tableLayoutPanel3.SuspendLayout();
			this.tableLayoutPanel4.SuspendLayout();
			this.table_name.SuspendLayout();
			this.table_location.SuspendLayout();
			this.SuspendLayout();
			// 
			// table_buttons
			// 
			this.table_buttons.ColumnCount = 3;
			this.table_buttons.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
			this.table_buttons.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.table_buttons.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.table_buttons.Controls.Add(this.button_save, 1, 0);
			this.table_buttons.Controls.Add(this.button_cancel, 2, 0);
			this.table_buttons.Dock = System.Windows.Forms.DockStyle.Bottom;
			this.table_buttons.Location = new System.Drawing.Point(0, 265);
			this.table_buttons.Name = "table_buttons";
			this.table_buttons.RowCount = 1;
			this.table_buttons.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.table_buttons.Size = new System.Drawing.Size(392, 33);
			this.table_buttons.TabIndex = 1;
			// 
			// button_save
			// 
			this.button_save.Dock = System.Windows.Forms.DockStyle.Fill;
			this.button_save.Location = new System.Drawing.Point(103, 3);
			this.button_save.Name = "button_save";
			this.button_save.Size = new System.Drawing.Size(140, 27);
			this.button_save.TabIndex = 0;
			this.button_save.Text = "Save";
			this.button_save.UseVisualStyleBackColor = true;
			this.button_save.Click += new System.EventHandler(this.button_save_Click);
			// 
			// button_cancel
			// 
			this.button_cancel.Dock = System.Windows.Forms.DockStyle.Fill;
			this.button_cancel.Location = new System.Drawing.Point(249, 3);
			this.button_cancel.Name = "button_cancel";
			this.button_cancel.Size = new System.Drawing.Size(140, 27);
			this.button_cancel.TabIndex = 1;
			this.button_cancel.Text = "Cancel";
			this.button_cancel.UseVisualStyleBackColor = true;
			this.button_cancel.Click += new System.EventHandler(this.button_cancel_Click);
			// 
			// txt_display
			// 
			this.txt_display.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_display.Location = new System.Drawing.Point(103, 123);
			this.txt_display.Name = "txt_display";
			this.txt_display.Size = new System.Drawing.Size(286, 20);
			this.txt_display.TabIndex = 13;
			this.txt_display.TextChanged += new System.EventHandler(this.txt_display_TextChanged);
			// 
			// txt_pass
			// 
			this.txt_pass.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_pass.Location = new System.Drawing.Point(103, 75);
			this.txt_pass.Name = "txt_pass";
			this.txt_pass.Size = new System.Drawing.Size(286, 20);
			this.txt_pass.TabIndex = 10;
			this.txt_pass.TextChanged += new System.EventHandler(this.txt_pass_TextChanged);
			// 
			// txt_user
			// 
			this.txt_user.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_user.Location = new System.Drawing.Point(103, 51);
			this.txt_user.Name = "txt_user";
			this.txt_user.Size = new System.Drawing.Size(286, 20);
			this.txt_user.TabIndex = 9;
			this.txt_user.TextChanged += new System.EventHandler(this.txt_user_TextChanged);
			// 
			// lbl_display
			// 
			this.lbl_display.AutoSize = true;
			this.lbl_display.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_display.Location = new System.Drawing.Point(3, 120);
			this.lbl_display.Name = "lbl_display";
			this.lbl_display.Size = new System.Drawing.Size(94, 24);
			this.lbl_display.TabIndex = 8;
			this.lbl_display.Text = "Displayname";
			this.lbl_display.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lbl_name
			// 
			this.lbl_name.AutoSize = true;
			this.lbl_name.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_name.Location = new System.Drawing.Point(3, 96);
			this.lbl_name.Name = "lbl_name";
			this.lbl_name.Size = new System.Drawing.Size(94, 24);
			this.lbl_name.TabIndex = 6;
			this.lbl_name.Text = "Name";
			this.lbl_name.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lbl_pass
			// 
			this.lbl_pass.AutoSize = true;
			this.lbl_pass.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_pass.Location = new System.Drawing.Point(3, 72);
			this.lbl_pass.Name = "lbl_pass";
			this.lbl_pass.Size = new System.Drawing.Size(94, 24);
			this.lbl_pass.TabIndex = 5;
			this.lbl_pass.Text = "Password";
			this.lbl_pass.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lbl_user
			// 
			this.lbl_user.AutoSize = true;
			this.lbl_user.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_user.Location = new System.Drawing.Point(3, 48);
			this.lbl_user.Name = "lbl_user";
			this.lbl_user.Size = new System.Drawing.Size(94, 24);
			this.lbl_user.TabIndex = 4;
			this.lbl_user.Text = "Username";
			this.lbl_user.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// txt_guid
			// 
			this.txt_guid.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_guid.Location = new System.Drawing.Point(103, 3);
			this.txt_guid.Name = "txt_guid";
			this.txt_guid.ReadOnly = true;
			this.txt_guid.Size = new System.Drawing.Size(286, 20);
			this.txt_guid.TabIndex = 1;
			// 
			// lbl_guid
			// 
			this.lbl_guid.AutoSize = true;
			this.lbl_guid.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_guid.Location = new System.Drawing.Point(3, 0);
			this.lbl_guid.Name = "lbl_guid";
			this.lbl_guid.Size = new System.Drawing.Size(94, 24);
			this.lbl_guid.TabIndex = 0;
			this.lbl_guid.Text = "GUID";
			this.lbl_guid.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lbl_email
			// 
			this.lbl_email.AutoSize = true;
			this.lbl_email.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_email.Location = new System.Drawing.Point(3, 24);
			this.lbl_email.Name = "lbl_email";
			this.lbl_email.Size = new System.Drawing.Size(94, 24);
			this.lbl_email.TabIndex = 2;
			this.lbl_email.Text = "Email";
			this.lbl_email.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// txt_email
			// 
			this.txt_email.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_email.Location = new System.Drawing.Point(103, 27);
			this.txt_email.Name = "txt_email";
			this.txt_email.Size = new System.Drawing.Size(286, 20);
			this.txt_email.TabIndex = 3;
			this.txt_email.TextChanged += new System.EventHandler(this.txt_email_TextChanged);
			// 
			// table_main
			// 
			this.table_main.ColumnCount = 2;
			this.table_main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
			this.table_main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.table_main.Controls.Add(this.txt_email, 1, 1);
			this.table_main.Controls.Add(this.lbl_email, 0, 1);
			this.table_main.Controls.Add(this.lbl_guid, 0, 0);
			this.table_main.Controls.Add(this.txt_guid, 1, 0);
			this.table_main.Controls.Add(this.lbl_user, 0, 2);
			this.table_main.Controls.Add(this.lbl_pass, 0, 3);
			this.table_main.Controls.Add(this.lbl_name, 0, 4);
			this.table_main.Controls.Add(this.txt_user, 1, 2);
			this.table_main.Controls.Add(this.txt_pass, 1, 3);
			this.table_main.Controls.Add(this.tableLayoutPanel3, 1, 10);
			this.table_main.Controls.Add(this.tableLayoutPanel4, 1, 9);
			this.table_main.Controls.Add(this.lbl_display, 0, 5);
			this.table_main.Controls.Add(this.table_name, 1, 4);
			this.table_main.Controls.Add(this.txt_display, 1, 5);
			this.table_main.Controls.Add(this.lbl_birth, 0, 6);
			this.table_main.Controls.Add(this.lbl_location, 0, 7);
			this.table_main.Controls.Add(this.lbl_preference, 0, 10);
			this.table_main.Controls.Add(this.lbl_description, 0, 9);
			this.table_main.Controls.Add(this.lbl_locatime, 0, 8);
			this.table_main.Controls.Add(this.table_location, 1, 7);
			this.table_main.Controls.Add(this.date_birth, 1, 6);
			this.table_main.Controls.Add(this.date_location, 1, 8);
			this.table_main.Dock = System.Windows.Forms.DockStyle.Fill;
			this.table_main.Location = new System.Drawing.Point(0, 0);
			this.table_main.Name = "table_main";
			this.table_main.RowCount = 12;
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.Size = new System.Drawing.Size(392, 298);
			this.table_main.TabIndex = 0;
			// 
			// tableLayoutPanel3
			// 
			this.tableLayoutPanel3.ColumnCount = 4;
			this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.tableLayoutPanel3.Controls.Add(this.txt_preference, 0, 0);
			this.tableLayoutPanel3.Controls.Add(this.btn_pref_add, 1, 0);
			this.tableLayoutPanel3.Controls.Add(this.btn_pref_del, 2, 0);
			this.tableLayoutPanel3.Controls.Add(this.btn_pref_edit, 3, 0);
			this.tableLayoutPanel3.Dock = System.Windows.Forms.DockStyle.Fill;
			this.tableLayoutPanel3.Location = new System.Drawing.Point(100, 240);
			this.tableLayoutPanel3.Margin = new System.Windows.Forms.Padding(0);
			this.tableLayoutPanel3.Name = "tableLayoutPanel3";
			this.tableLayoutPanel3.RowCount = 1;
			this.tableLayoutPanel3.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.tableLayoutPanel3.Size = new System.Drawing.Size(292, 24);
			this.tableLayoutPanel3.TabIndex = 18;
			// 
			// txt_preference
			// 
			this.txt_preference.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_preference.Location = new System.Drawing.Point(3, 3);
			this.txt_preference.Name = "txt_preference";
			this.txt_preference.ReadOnly = true;
			this.txt_preference.Size = new System.Drawing.Size(214, 20);
			this.txt_preference.TabIndex = 0;
			// 
			// btn_pref_add
			// 
			this.btn_pref_add.Dock = System.Windows.Forms.DockStyle.Fill;
			this.btn_pref_add.FlatAppearance.BorderSize = 0;
			this.btn_pref_add.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btn_pref_add.Image = ((System.Drawing.Image)(resources.GetObject("btn_pref_add.Image")));
			this.btn_pref_add.Location = new System.Drawing.Point(220, 0);
			this.btn_pref_add.Margin = new System.Windows.Forms.Padding(0);
			this.btn_pref_add.Name = "btn_pref_add";
			this.btn_pref_add.Size = new System.Drawing.Size(24, 24);
			this.btn_pref_add.TabIndex = 1;
			this.btn_pref_add.UseVisualStyleBackColor = true;
			this.btn_pref_add.Click += new System.EventHandler(this.btn_pref_add_Click);
			// 
			// btn_pref_del
			// 
			this.btn_pref_del.Dock = System.Windows.Forms.DockStyle.Fill;
			this.btn_pref_del.FlatAppearance.BorderSize = 0;
			this.btn_pref_del.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btn_pref_del.Image = ((System.Drawing.Image)(resources.GetObject("btn_pref_del.Image")));
			this.btn_pref_del.Location = new System.Drawing.Point(244, 0);
			this.btn_pref_del.Margin = new System.Windows.Forms.Padding(0);
			this.btn_pref_del.Name = "btn_pref_del";
			this.btn_pref_del.Size = new System.Drawing.Size(24, 24);
			this.btn_pref_del.TabIndex = 2;
			this.btn_pref_del.UseVisualStyleBackColor = true;
			this.btn_pref_del.Click += new System.EventHandler(this.btn_pref_del_Click);
			// 
			// btn_pref_edit
			// 
			this.btn_pref_edit.Dock = System.Windows.Forms.DockStyle.Fill;
			this.btn_pref_edit.FlatAppearance.BorderSize = 0;
			this.btn_pref_edit.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btn_pref_edit.Image = ((System.Drawing.Image)(resources.GetObject("btn_pref_edit.Image")));
			this.btn_pref_edit.Location = new System.Drawing.Point(268, 0);
			this.btn_pref_edit.Margin = new System.Windows.Forms.Padding(0);
			this.btn_pref_edit.Name = "btn_pref_edit";
			this.btn_pref_edit.Size = new System.Drawing.Size(24, 24);
			this.btn_pref_edit.TabIndex = 3;
			this.btn_pref_edit.UseVisualStyleBackColor = true;
			this.btn_pref_edit.Click += new System.EventHandler(this.btn_pref_edit_Click);
			// 
			// tableLayoutPanel4
			// 
			this.tableLayoutPanel4.ColumnCount = 4;
			this.tableLayoutPanel4.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.tableLayoutPanel4.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.tableLayoutPanel4.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.tableLayoutPanel4.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.tableLayoutPanel4.Controls.Add(this.txt_description, 0, 0);
			this.tableLayoutPanel4.Controls.Add(this.btn_desc_add, 1, 0);
			this.tableLayoutPanel4.Controls.Add(this.btn_desc_del, 2, 0);
			this.tableLayoutPanel4.Controls.Add(this.btn_desc_edit, 3, 0);
			this.tableLayoutPanel4.Dock = System.Windows.Forms.DockStyle.Fill;
			this.tableLayoutPanel4.Location = new System.Drawing.Point(100, 216);
			this.tableLayoutPanel4.Margin = new System.Windows.Forms.Padding(0);
			this.tableLayoutPanel4.Name = "tableLayoutPanel4";
			this.tableLayoutPanel4.RowCount = 1;
			this.tableLayoutPanel4.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.tableLayoutPanel4.Size = new System.Drawing.Size(292, 24);
			this.tableLayoutPanel4.TabIndex = 19;
			// 
			// txt_description
			// 
			this.txt_description.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_description.Location = new System.Drawing.Point(3, 3);
			this.txt_description.Name = "txt_description";
			this.txt_description.ReadOnly = true;
			this.txt_description.Size = new System.Drawing.Size(214, 20);
			this.txt_description.TabIndex = 0;
			// 
			// btn_desc_add
			// 
			this.btn_desc_add.Dock = System.Windows.Forms.DockStyle.Fill;
			this.btn_desc_add.FlatAppearance.BorderSize = 0;
			this.btn_desc_add.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btn_desc_add.Image = global::StalkrAdminTool.Properties.Resources.add2;
			this.btn_desc_add.Location = new System.Drawing.Point(220, 0);
			this.btn_desc_add.Margin = new System.Windows.Forms.Padding(0);
			this.btn_desc_add.Name = "btn_desc_add";
			this.btn_desc_add.Size = new System.Drawing.Size(24, 24);
			this.btn_desc_add.TabIndex = 4;
			this.btn_desc_add.UseVisualStyleBackColor = true;
			this.btn_desc_add.Click += new System.EventHandler(this.btn_desc_add_Click);
			// 
			// btn_desc_del
			// 
			this.btn_desc_del.Dock = System.Windows.Forms.DockStyle.Fill;
			this.btn_desc_del.FlatAppearance.BorderSize = 0;
			this.btn_desc_del.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btn_desc_del.Image = ((System.Drawing.Image)(resources.GetObject("btn_desc_del.Image")));
			this.btn_desc_del.Location = new System.Drawing.Point(244, 0);
			this.btn_desc_del.Margin = new System.Windows.Forms.Padding(0);
			this.btn_desc_del.Name = "btn_desc_del";
			this.btn_desc_del.Size = new System.Drawing.Size(24, 24);
			this.btn_desc_del.TabIndex = 5;
			this.btn_desc_del.UseVisualStyleBackColor = true;
			this.btn_desc_del.Click += new System.EventHandler(this.btn_desc_del_Click);
			// 
			// btn_desc_edit
			// 
			this.btn_desc_edit.Dock = System.Windows.Forms.DockStyle.Fill;
			this.btn_desc_edit.FlatAppearance.BorderSize = 0;
			this.btn_desc_edit.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btn_desc_edit.Image = ((System.Drawing.Image)(resources.GetObject("btn_desc_edit.Image")));
			this.btn_desc_edit.Location = new System.Drawing.Point(268, 0);
			this.btn_desc_edit.Margin = new System.Windows.Forms.Padding(0);
			this.btn_desc_edit.Name = "btn_desc_edit";
			this.btn_desc_edit.Size = new System.Drawing.Size(24, 24);
			this.btn_desc_edit.TabIndex = 6;
			this.btn_desc_edit.UseVisualStyleBackColor = true;
			this.btn_desc_edit.Click += new System.EventHandler(this.btn_desc_edit_Click);
			// 
			// table_name
			// 
			this.table_name.ColumnCount = 2;
			this.table_name.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.table_name.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.table_name.Controls.Add(this.txt_firstname, 0, 0);
			this.table_name.Controls.Add(this.txt_lastname, 1, 0);
			this.table_name.Dock = System.Windows.Forms.DockStyle.Fill;
			this.table_name.Location = new System.Drawing.Point(100, 96);
			this.table_name.Margin = new System.Windows.Forms.Padding(0);
			this.table_name.Name = "table_name";
			this.table_name.RowCount = 1;
			this.table_name.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.table_name.Size = new System.Drawing.Size(292, 24);
			this.table_name.TabIndex = 20;
			// 
			// txt_firstname
			// 
			this.txt_firstname.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_firstname.Location = new System.Drawing.Point(3, 3);
			this.txt_firstname.Name = "txt_firstname";
			this.txt_firstname.Size = new System.Drawing.Size(140, 20);
			this.txt_firstname.TabIndex = 0;
			this.txt_firstname.TextChanged += new System.EventHandler(this.txt_name_TextChanged);
			// 
			// txt_lastname
			// 
			this.txt_lastname.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_lastname.Location = new System.Drawing.Point(149, 3);
			this.txt_lastname.Name = "txt_lastname";
			this.txt_lastname.Size = new System.Drawing.Size(140, 20);
			this.txt_lastname.TabIndex = 1;
			this.txt_lastname.TextChanged += new System.EventHandler(this.txt_name_TextChanged);
			// 
			// lbl_birth
			// 
			this.lbl_birth.AutoSize = true;
			this.lbl_birth.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_birth.Location = new System.Drawing.Point(3, 144);
			this.lbl_birth.Name = "lbl_birth";
			this.lbl_birth.Size = new System.Drawing.Size(94, 24);
			this.lbl_birth.TabIndex = 14;
			this.lbl_birth.Text = "Birthdate";
			this.lbl_birth.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lbl_location
			// 
			this.lbl_location.AutoSize = true;
			this.lbl_location.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_location.Location = new System.Drawing.Point(3, 168);
			this.lbl_location.Name = "lbl_location";
			this.lbl_location.Size = new System.Drawing.Size(94, 24);
			this.lbl_location.TabIndex = 15;
			this.lbl_location.Text = "Location";
			this.lbl_location.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lbl_preference
			// 
			this.lbl_preference.AutoSize = true;
			this.lbl_preference.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_preference.Location = new System.Drawing.Point(3, 240);
			this.lbl_preference.Name = "lbl_preference";
			this.lbl_preference.Size = new System.Drawing.Size(94, 24);
			this.lbl_preference.TabIndex = 17;
			this.lbl_preference.Text = "Preference";
			this.lbl_preference.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lbl_description
			// 
			this.lbl_description.AutoSize = true;
			this.lbl_description.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_description.Location = new System.Drawing.Point(3, 216);
			this.lbl_description.Name = "lbl_description";
			this.lbl_description.Size = new System.Drawing.Size(94, 24);
			this.lbl_description.TabIndex = 16;
			this.lbl_description.Text = "Description";
			this.lbl_description.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lbl_locatime
			// 
			this.lbl_locatime.AutoSize = true;
			this.lbl_locatime.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_locatime.Location = new System.Drawing.Point(3, 192);
			this.lbl_locatime.Name = "lbl_locatime";
			this.lbl_locatime.Size = new System.Drawing.Size(94, 24);
			this.lbl_locatime.TabIndex = 21;
			this.lbl_locatime.Text = "Location update";
			this.lbl_locatime.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// table_location
			// 
			this.table_location.ColumnCount = 4;
			this.table_location.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_location.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.table_location.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_location.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.table_location.Controls.Add(this.txt_lon, 3, 0);
			this.table_location.Controls.Add(this.txt_lat, 1, 0);
			this.table_location.Controls.Add(this.lbl_lat, 0, 0);
			this.table_location.Controls.Add(this.lbl_lon, 2, 0);
			this.table_location.Dock = System.Windows.Forms.DockStyle.Fill;
			this.table_location.Location = new System.Drawing.Point(100, 168);
			this.table_location.Margin = new System.Windows.Forms.Padding(0);
			this.table_location.Name = "table_location";
			this.table_location.RowCount = 1;
			this.table_location.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.table_location.Size = new System.Drawing.Size(292, 24);
			this.table_location.TabIndex = 22;
			// 
			// txt_lon
			// 
			this.txt_lon.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_lon.Location = new System.Drawing.Point(173, 3);
			this.txt_lon.Name = "txt_lon";
			this.txt_lon.Size = new System.Drawing.Size(116, 20);
			this.txt_lon.TabIndex = 1;
			this.txt_lon.TextChanged += new System.EventHandler(this.txt_location_TextChanged);
			// 
			// txt_lat
			// 
			this.txt_lat.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_lat.Location = new System.Drawing.Point(27, 3);
			this.txt_lat.Name = "txt_lat";
			this.txt_lat.Size = new System.Drawing.Size(116, 20);
			this.txt_lat.TabIndex = 0;
			this.txt_lat.TextChanged += new System.EventHandler(this.txt_location_TextChanged);
			// 
			// lbl_lat
			// 
			this.lbl_lat.AutoSize = true;
			this.lbl_lat.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_lat.Location = new System.Drawing.Point(0, 0);
			this.lbl_lat.Margin = new System.Windows.Forms.Padding(0);
			this.lbl_lat.Name = "lbl_lat";
			this.lbl_lat.Size = new System.Drawing.Size(24, 24);
			this.lbl_lat.TabIndex = 2;
			this.lbl_lat.Text = "lat";
			this.lbl_lat.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
			// 
			// lbl_lon
			// 
			this.lbl_lon.AutoSize = true;
			this.lbl_lon.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_lon.Location = new System.Drawing.Point(146, 0);
			this.lbl_lon.Margin = new System.Windows.Forms.Padding(0);
			this.lbl_lon.Name = "lbl_lon";
			this.lbl_lon.Size = new System.Drawing.Size(24, 24);
			this.lbl_lon.TabIndex = 3;
			this.lbl_lon.Text = "lon";
			this.lbl_lon.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
			// 
			// date_birth
			// 
			this.date_birth.CustomFormat = "dd/MM/yy";
			this.date_birth.Dock = System.Windows.Forms.DockStyle.Fill;
			this.date_birth.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
			this.date_birth.Location = new System.Drawing.Point(103, 147);
			this.date_birth.Name = "date_birth";
			this.date_birth.Size = new System.Drawing.Size(286, 20);
			this.date_birth.TabIndex = 23;
			this.date_birth.ValueChanged += new System.EventHandler(this.date_birth_ValueChanged);
			// 
			// date_location
			// 
			this.date_location.CustomFormat = "dd/MM/yy HH:mm";
			this.date_location.Dock = System.Windows.Forms.DockStyle.Fill;
			this.date_location.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
			this.date_location.Location = new System.Drawing.Point(103, 195);
			this.date_location.Name = "date_location";
			this.date_location.Size = new System.Drawing.Size(286, 20);
			this.date_location.TabIndex = 24;
			this.date_location.ValueChanged += new System.EventHandler(this.date_location_ValueChanged);
			// 
			// UserForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(392, 298);
			this.Controls.Add(this.table_buttons);
			this.Controls.Add(this.table_main);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "UserForm";
			this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Hide;
			this.Text = "Stalkr Admin Tool - User Form";
			this.table_buttons.ResumeLayout(false);
			this.table_main.ResumeLayout(false);
			this.table_main.PerformLayout();
			this.tableLayoutPanel3.ResumeLayout(false);
			this.tableLayoutPanel3.PerformLayout();
			this.tableLayoutPanel4.ResumeLayout(false);
			this.tableLayoutPanel4.PerformLayout();
			this.table_name.ResumeLayout(false);
			this.table_name.PerformLayout();
			this.table_location.ResumeLayout(false);
			this.table_location.PerformLayout();
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.TableLayoutPanel table_buttons;
		private System.Windows.Forms.Button button_save;
		private System.Windows.Forms.Button button_cancel;
		private System.Windows.Forms.TextBox txt_display;
		private System.Windows.Forms.TextBox txt_pass;
		private System.Windows.Forms.TextBox txt_user;
		private System.Windows.Forms.Label lbl_display;
		private System.Windows.Forms.Label lbl_name;
		private System.Windows.Forms.Label lbl_pass;
		private System.Windows.Forms.Label lbl_user;
		private System.Windows.Forms.TextBox txt_guid;
		private System.Windows.Forms.Label lbl_guid;
		private System.Windows.Forms.Label lbl_email;
		private System.Windows.Forms.TextBox txt_email;
		private System.Windows.Forms.TableLayoutPanel table_main;
		private System.Windows.Forms.Label lbl_birth;
		private System.Windows.Forms.Label lbl_location;
		private System.Windows.Forms.Label lbl_description;
		private System.Windows.Forms.Label lbl_preference;
		private System.Windows.Forms.TableLayoutPanel tableLayoutPanel3;
		private System.Windows.Forms.TextBox txt_preference;
		private System.Windows.Forms.TableLayoutPanel tableLayoutPanel4;
		private System.Windows.Forms.TextBox txt_description;
		private System.Windows.Forms.TableLayoutPanel table_name;
		private System.Windows.Forms.TextBox txt_firstname;
		private System.Windows.Forms.TextBox txt_lastname;
		private System.Windows.Forms.Label lbl_locatime;
		private System.Windows.Forms.TableLayoutPanel table_location;
		private System.Windows.Forms.TextBox txt_lon;
		private System.Windows.Forms.TextBox txt_lat;
		private System.Windows.Forms.Label lbl_lat;
		private System.Windows.Forms.Label lbl_lon;
		private System.Windows.Forms.DateTimePicker date_birth;
		private System.Windows.Forms.DateTimePicker date_location;
		private System.Windows.Forms.Button btn_pref_add;
		private System.Windows.Forms.Button btn_pref_del;
		private System.Windows.Forms.Button btn_pref_edit;
		private System.Windows.Forms.Button btn_desc_add;
		private System.Windows.Forms.Button btn_desc_del;
		private System.Windows.Forms.Button btn_desc_edit;
	}
}