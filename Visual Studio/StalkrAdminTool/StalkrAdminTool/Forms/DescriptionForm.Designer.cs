namespace StalkrAdminTool
{
	partial class DescriptionForm
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
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(DescriptionForm));
			this.table_buttons = new System.Windows.Forms.TableLayoutPanel();
			this.button_save = new System.Windows.Forms.Button();
			this.button_cancel = new System.Windows.Forms.Button();
			this.lbl_region = new System.Windows.Forms.Label();
			this.lbl_orientation = new System.Windows.Forms.Label();
			this.lbl_gender = new System.Windows.Forms.Label();
			this.lbl_age = new System.Windows.Forms.Label();
			this.txt_guid = new System.Windows.Forms.TextBox();
			this.lbl_guid = new System.Windows.Forms.Label();
			this.table_main = new System.Windows.Forms.TableLayoutPanel();
			this.lbl_timestamp = new System.Windows.Forms.Label();
			this.lbl_smoking = new System.Windows.Forms.Label();
			this.lbl_drinking = new System.Windows.Forms.Label();
			this.table_age = new System.Windows.Forms.TableLayoutPanel();
			this.num_age = new System.Windows.Forms.NumericUpDown();
			this.label_ageto = new System.Windows.Forms.Label();
			this.num_agemax = new System.Windows.Forms.NumericUpDown();
			this.chk_gender = new System.Windows.Forms.CheckedListBox();
			this.chk_orientation = new System.Windows.Forms.CheckedListBox();
			this.chk_region = new System.Windows.Forms.CheckedListBox();
			this.chk_smoking = new System.Windows.Forms.CheckedListBox();
			this.txt_timestamp = new System.Windows.Forms.TextBox();
			this.chk_drinking = new System.Windows.Forms.CheckedListBox();
			this.table_buttons.SuspendLayout();
			this.table_main.SuspendLayout();
			this.table_age.SuspendLayout();
			((System.ComponentModel.ISupportInitialize)(this.num_age)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.num_agemax)).BeginInit();
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
			this.table_buttons.Location = new System.Drawing.Point(0, 312);
			this.table_buttons.Name = "table_buttons";
			this.table_buttons.RowCount = 1;
			this.table_buttons.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.table_buttons.Size = new System.Drawing.Size(394, 33);
			this.table_buttons.TabIndex = 1;
			// 
			// button_save
			// 
			this.button_save.Dock = System.Windows.Forms.DockStyle.Fill;
			this.button_save.Location = new System.Drawing.Point(103, 3);
			this.button_save.Name = "button_save";
			this.button_save.Size = new System.Drawing.Size(141, 27);
			this.button_save.TabIndex = 0;
			this.button_save.Text = "Save";
			this.button_save.UseVisualStyleBackColor = true;
			this.button_save.Click += new System.EventHandler(this.button_save_Click);
			// 
			// button_cancel
			// 
			this.button_cancel.Dock = System.Windows.Forms.DockStyle.Fill;
			this.button_cancel.Location = new System.Drawing.Point(250, 3);
			this.button_cancel.Name = "button_cancel";
			this.button_cancel.Size = new System.Drawing.Size(141, 27);
			this.button_cancel.TabIndex = 1;
			this.button_cancel.Text = "Cancel";
			this.button_cancel.UseVisualStyleBackColor = true;
			this.button_cancel.Click += new System.EventHandler(this.button_cancel_Click);
			// 
			// lbl_region
			// 
			this.lbl_region.AutoSize = true;
			this.lbl_region.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_region.Location = new System.Drawing.Point(3, 168);
			this.lbl_region.Name = "lbl_region";
			this.lbl_region.Padding = new System.Windows.Forms.Padding(0, 7, 0, 0);
			this.lbl_region.Size = new System.Drawing.Size(94, 48);
			this.lbl_region.TabIndex = 8;
			this.lbl_region.Text = "Region";
			// 
			// lbl_orientation
			// 
			this.lbl_orientation.AutoSize = true;
			this.lbl_orientation.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_orientation.Location = new System.Drawing.Point(3, 120);
			this.lbl_orientation.Name = "lbl_orientation";
			this.lbl_orientation.Padding = new System.Windows.Forms.Padding(0, 7, 0, 0);
			this.lbl_orientation.Size = new System.Drawing.Size(94, 48);
			this.lbl_orientation.TabIndex = 6;
			this.lbl_orientation.Text = "Orientation";
			// 
			// lbl_gender
			// 
			this.lbl_gender.AutoSize = true;
			this.lbl_gender.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_gender.Location = new System.Drawing.Point(3, 72);
			this.lbl_gender.Name = "lbl_gender";
			this.lbl_gender.Padding = new System.Windows.Forms.Padding(0, 7, 0, 0);
			this.lbl_gender.Size = new System.Drawing.Size(94, 48);
			this.lbl_gender.TabIndex = 5;
			this.lbl_gender.Text = "Gender";
			// 
			// lbl_age
			// 
			this.lbl_age.AutoSize = true;
			this.lbl_age.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_age.Location = new System.Drawing.Point(3, 48);
			this.lbl_age.Name = "lbl_age";
			this.lbl_age.Padding = new System.Windows.Forms.Padding(0, 7, 0, 0);
			this.lbl_age.Size = new System.Drawing.Size(94, 24);
			this.lbl_age.TabIndex = 4;
			this.lbl_age.Text = "Age";
			// 
			// txt_guid
			// 
			this.txt_guid.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_guid.Location = new System.Drawing.Point(103, 3);
			this.txt_guid.Name = "txt_guid";
			this.txt_guid.ReadOnly = true;
			this.txt_guid.Size = new System.Drawing.Size(288, 20);
			this.txt_guid.TabIndex = 1;
			// 
			// lbl_guid
			// 
			this.lbl_guid.AutoSize = true;
			this.lbl_guid.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_guid.Location = new System.Drawing.Point(3, 0);
			this.lbl_guid.Name = "lbl_guid";
			this.lbl_guid.Padding = new System.Windows.Forms.Padding(0, 7, 0, 0);
			this.lbl_guid.Size = new System.Drawing.Size(94, 24);
			this.lbl_guid.TabIndex = 0;
			this.lbl_guid.Text = "GUID";
			// 
			// table_main
			// 
			this.table_main.ColumnCount = 2;
			this.table_main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
			this.table_main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.table_main.Controls.Add(this.lbl_timestamp, 0, 1);
			this.table_main.Controls.Add(this.lbl_guid, 0, 0);
			this.table_main.Controls.Add(this.txt_guid, 1, 0);
			this.table_main.Controls.Add(this.lbl_age, 0, 2);
			this.table_main.Controls.Add(this.lbl_gender, 0, 3);
			this.table_main.Controls.Add(this.lbl_orientation, 0, 4);
			this.table_main.Controls.Add(this.lbl_region, 0, 5);
			this.table_main.Controls.Add(this.lbl_smoking, 0, 6);
			this.table_main.Controls.Add(this.lbl_drinking, 0, 7);
			this.table_main.Controls.Add(this.table_age, 1, 2);
			this.table_main.Controls.Add(this.chk_gender, 1, 3);
			this.table_main.Controls.Add(this.chk_orientation, 3, 4);
			this.table_main.Controls.Add(this.chk_region, 3, 5);
			this.table_main.Controls.Add(this.chk_smoking, 3, 6);
			this.table_main.Controls.Add(this.txt_timestamp, 1, 1);
			this.table_main.Controls.Add(this.chk_drinking, 3, 7);
			this.table_main.Dock = System.Windows.Forms.DockStyle.Fill;
			this.table_main.Location = new System.Drawing.Point(0, 0);
			this.table_main.Name = "table_main";
			this.table_main.RowCount = 9;
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 48F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 48F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 48F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 48F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 48F));
			this.table_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 48F));
			this.table_main.Size = new System.Drawing.Size(394, 345);
			this.table_main.TabIndex = 0;
			// 
			// lbl_timestamp
			// 
			this.lbl_timestamp.AutoSize = true;
			this.lbl_timestamp.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_timestamp.Location = new System.Drawing.Point(3, 24);
			this.lbl_timestamp.Name = "lbl_timestamp";
			this.lbl_timestamp.Padding = new System.Windows.Forms.Padding(0, 7, 0, 0);
			this.lbl_timestamp.Size = new System.Drawing.Size(94, 24);
			this.lbl_timestamp.TabIndex = 2;
			this.lbl_timestamp.Text = "Timestamp";
			// 
			// lbl_smoking
			// 
			this.lbl_smoking.AutoSize = true;
			this.lbl_smoking.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_smoking.Location = new System.Drawing.Point(3, 216);
			this.lbl_smoking.Name = "lbl_smoking";
			this.lbl_smoking.Padding = new System.Windows.Forms.Padding(0, 7, 0, 0);
			this.lbl_smoking.Size = new System.Drawing.Size(94, 48);
			this.lbl_smoking.TabIndex = 14;
			this.lbl_smoking.Text = "Smoking";
			// 
			// lbl_drinking
			// 
			this.lbl_drinking.AutoSize = true;
			this.lbl_drinking.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_drinking.Location = new System.Drawing.Point(3, 264);
			this.lbl_drinking.Name = "lbl_drinking";
			this.lbl_drinking.Padding = new System.Windows.Forms.Padding(0, 7, 0, 0);
			this.lbl_drinking.Size = new System.Drawing.Size(94, 48);
			this.lbl_drinking.TabIndex = 15;
			this.lbl_drinking.Text = "Drinking";
			// 
			// table_age
			// 
			this.table_age.ColumnCount = 3;
			this.table_age.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.table_age.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.table_age.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.table_age.Controls.Add(this.num_age, 0, 0);
			this.table_age.Controls.Add(this.label_ageto, 1, 0);
			this.table_age.Controls.Add(this.num_agemax, 2, 0);
			this.table_age.Dock = System.Windows.Forms.DockStyle.Fill;
			this.table_age.Location = new System.Drawing.Point(100, 48);
			this.table_age.Margin = new System.Windows.Forms.Padding(0);
			this.table_age.Name = "table_age";
			this.table_age.RowCount = 1;
			this.table_age.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.table_age.Size = new System.Drawing.Size(294, 24);
			this.table_age.TabIndex = 28;
			// 
			// num_age
			// 
			this.num_age.Dock = System.Windows.Forms.DockStyle.Fill;
			this.num_age.Location = new System.Drawing.Point(3, 3);
			this.num_age.Name = "num_age";
			this.num_age.Size = new System.Drawing.Size(129, 20);
			this.num_age.TabIndex = 26;
			// 
			// label_ageto
			// 
			this.label_ageto.AutoSize = true;
			this.label_ageto.Dock = System.Windows.Forms.DockStyle.Fill;
			this.label_ageto.Location = new System.Drawing.Point(138, 0);
			this.label_ageto.Name = "label_ageto";
			this.label_ageto.Size = new System.Drawing.Size(18, 24);
			this.label_ageto.TabIndex = 27;
			this.label_ageto.Text = "-";
			this.label_ageto.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			// 
			// num_agemax
			// 
			this.num_agemax.Dock = System.Windows.Forms.DockStyle.Fill;
			this.num_agemax.Enabled = false;
			this.num_agemax.Location = new System.Drawing.Point(162, 3);
			this.num_agemax.Name = "num_agemax";
			this.num_agemax.Size = new System.Drawing.Size(129, 20);
			this.num_agemax.TabIndex = 28;
			// 
			// chk_gender
			// 
			this.chk_gender.CheckOnClick = true;
			this.chk_gender.Dock = System.Windows.Forms.DockStyle.Fill;
			this.chk_gender.FormattingEnabled = true;
			this.chk_gender.IntegralHeight = false;
			this.chk_gender.Location = new System.Drawing.Point(103, 75);
			this.chk_gender.Margin = new System.Windows.Forms.Padding(3, 3, 3, 0);
			this.chk_gender.MultiColumn = true;
			this.chk_gender.Name = "chk_gender";
			this.chk_gender.Size = new System.Drawing.Size(288, 45);
			this.chk_gender.TabIndex = 29;
			// 
			// chk_orientation
			// 
			this.chk_orientation.CheckOnClick = true;
			this.chk_orientation.Dock = System.Windows.Forms.DockStyle.Fill;
			this.chk_orientation.FormattingEnabled = true;
			this.chk_orientation.IntegralHeight = false;
			this.chk_orientation.Location = new System.Drawing.Point(103, 123);
			this.chk_orientation.Margin = new System.Windows.Forms.Padding(3, 3, 3, 0);
			this.chk_orientation.MultiColumn = true;
			this.chk_orientation.Name = "chk_orientation";
			this.chk_orientation.Size = new System.Drawing.Size(288, 45);
			this.chk_orientation.TabIndex = 30;
			// 
			// chk_region
			// 
			this.chk_region.CheckOnClick = true;
			this.chk_region.Dock = System.Windows.Forms.DockStyle.Fill;
			this.chk_region.FormattingEnabled = true;
			this.chk_region.IntegralHeight = false;
			this.chk_region.Location = new System.Drawing.Point(103, 171);
			this.chk_region.Margin = new System.Windows.Forms.Padding(3, 3, 3, 0);
			this.chk_region.MultiColumn = true;
			this.chk_region.Name = "chk_region";
			this.chk_region.Size = new System.Drawing.Size(288, 45);
			this.chk_region.TabIndex = 31;
			// 
			// chk_smoking
			// 
			this.chk_smoking.CheckOnClick = true;
			this.chk_smoking.Dock = System.Windows.Forms.DockStyle.Fill;
			this.chk_smoking.FormattingEnabled = true;
			this.chk_smoking.IntegralHeight = false;
			this.chk_smoking.Location = new System.Drawing.Point(103, 219);
			this.chk_smoking.Margin = new System.Windows.Forms.Padding(3, 3, 3, 0);
			this.chk_smoking.MultiColumn = true;
			this.chk_smoking.Name = "chk_smoking";
			this.chk_smoking.Size = new System.Drawing.Size(288, 45);
			this.chk_smoking.TabIndex = 32;
			// 
			// txt_timestamp
			// 
			this.txt_timestamp.Dock = System.Windows.Forms.DockStyle.Fill;
			this.txt_timestamp.Location = new System.Drawing.Point(103, 27);
			this.txt_timestamp.Name = "txt_timestamp";
			this.txt_timestamp.ReadOnly = true;
			this.txt_timestamp.Size = new System.Drawing.Size(288, 20);
			this.txt_timestamp.TabIndex = 3;
			this.txt_timestamp.TextChanged += new System.EventHandler(this.txt_email_TextChanged);
			// 
			// chk_drinking
			// 
			this.chk_drinking.CheckOnClick = true;
			this.chk_drinking.Dock = System.Windows.Forms.DockStyle.Fill;
			this.chk_drinking.FormattingEnabled = true;
			this.chk_drinking.IntegralHeight = false;
			this.chk_drinking.Location = new System.Drawing.Point(103, 267);
			this.chk_drinking.Margin = new System.Windows.Forms.Padding(3, 3, 3, 0);
			this.chk_drinking.MultiColumn = true;
			this.chk_drinking.Name = "chk_drinking";
			this.chk_drinking.Size = new System.Drawing.Size(288, 45);
			this.chk_drinking.TabIndex = 33;
			// 
			// DescriptionForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(394, 345);
			this.Controls.Add(this.table_buttons);
			this.Controls.Add(this.table_main);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "DescriptionForm";
			this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Hide;
			this.Text = "Stalkr Admin Tool - Description Form";
			this.table_buttons.ResumeLayout(false);
			this.table_main.ResumeLayout(false);
			this.table_main.PerformLayout();
			this.table_age.ResumeLayout(false);
			this.table_age.PerformLayout();
			((System.ComponentModel.ISupportInitialize)(this.num_age)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.num_agemax)).EndInit();
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.TableLayoutPanel table_buttons;
		private System.Windows.Forms.Button button_save;
		private System.Windows.Forms.Button button_cancel;
		private System.Windows.Forms.Label lbl_region;
		private System.Windows.Forms.Label lbl_orientation;
		private System.Windows.Forms.Label lbl_gender;
		private System.Windows.Forms.Label lbl_age;
		private System.Windows.Forms.TextBox txt_guid;
		private System.Windows.Forms.Label lbl_guid;
		private System.Windows.Forms.TableLayoutPanel table_main;
		private System.Windows.Forms.Label lbl_smoking;
		private System.Windows.Forms.Label lbl_drinking;
		private System.Windows.Forms.Label lbl_timestamp;
		private System.Windows.Forms.TableLayoutPanel table_age;
		private System.Windows.Forms.NumericUpDown num_age;
		private System.Windows.Forms.Label label_ageto;
		private System.Windows.Forms.NumericUpDown num_agemax;
		private System.Windows.Forms.CheckedListBox chk_gender;
		private System.Windows.Forms.CheckedListBox chk_orientation;
		private System.Windows.Forms.CheckedListBox chk_region;
		private System.Windows.Forms.CheckedListBox chk_smoking;
		private System.Windows.Forms.TextBox txt_timestamp;
		private System.Windows.Forms.CheckedListBox chk_drinking;
	}
}