namespace StalkrAdminTool
{
	partial class RandomForm
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
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(RandomForm));
			this.num_amount = new System.Windows.Forms.NumericUpDown();
			this.btn_ok = new System.Windows.Forms.Button();
			this.lbl_warning = new System.Windows.Forms.Label();
			this.tbl_main = new System.Windows.Forms.TableLayoutPanel();
			this.tbl_buttons = new System.Windows.Forms.TableLayoutPanel();
			this.btn_cancel = new System.Windows.Forms.Button();
			this.lbl_amount = new System.Windows.Forms.Label();
			this.tbl_latitude = new System.Windows.Forms.TableLayoutPanel();
			this.num_latmin = new System.Windows.Forms.NumericUpDown();
			this.num_latmax = new System.Windows.Forms.NumericUpDown();
			this.tbl_longitude = new System.Windows.Forms.TableLayoutPanel();
			this.num_lonmin = new System.Windows.Forms.NumericUpDown();
			this.num_lonmax = new System.Windows.Forms.NumericUpDown();
			this.lbl_latitude = new System.Windows.Forms.Label();
			this.lbl_longitude = new System.Windows.Forms.Label();
			((System.ComponentModel.ISupportInitialize)(this.num_amount)).BeginInit();
			this.tbl_main.SuspendLayout();
			this.tbl_buttons.SuspendLayout();
			this.tbl_latitude.SuspendLayout();
			((System.ComponentModel.ISupportInitialize)(this.num_latmin)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.num_latmax)).BeginInit();
			this.tbl_longitude.SuspendLayout();
			((System.ComponentModel.ISupportInitialize)(this.num_lonmin)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.num_lonmax)).BeginInit();
			this.SuspendLayout();
			// 
			// num_amount
			// 
			this.num_amount.Dock = System.Windows.Forms.DockStyle.Fill;
			this.num_amount.Location = new System.Drawing.Point(78, 103);
			this.num_amount.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
			this.num_amount.Name = "num_amount";
			this.num_amount.Size = new System.Drawing.Size(213, 20);
			this.num_amount.TabIndex = 0;
			this.num_amount.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
			// 
			// btn_ok
			// 
			this.btn_ok.Dock = System.Windows.Forms.DockStyle.Fill;
			this.btn_ok.Location = new System.Drawing.Point(3, 3);
			this.btn_ok.Name = "btn_ok";
			this.btn_ok.Size = new System.Drawing.Size(103, 22);
			this.btn_ok.TabIndex = 1;
			this.btn_ok.Text = "Generate";
			this.btn_ok.UseVisualStyleBackColor = true;
			this.btn_ok.Click += new System.EventHandler(this.btn_ok_Click);
			// 
			// lbl_warning
			// 
			this.lbl_warning.AutoSize = true;
			this.lbl_warning.BackColor = System.Drawing.Color.Red;
			this.tbl_main.SetColumnSpan(this.lbl_warning, 2);
			this.lbl_warning.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_warning.Location = new System.Drawing.Point(3, 3);
			this.lbl_warning.Margin = new System.Windows.Forms.Padding(3);
			this.lbl_warning.Name = "lbl_warning";
			this.lbl_warning.Size = new System.Drawing.Size(288, 94);
			this.lbl_warning.TabIndex = 2;
			this.lbl_warning.Text = resources.GetString("lbl_warning.Text");
			// 
			// tbl_main
			// 
			this.tbl_main.ColumnCount = 2;
			this.tbl_main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 75F));
			this.tbl_main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.tbl_main.Controls.Add(this.tbl_buttons, 1, 4);
			this.tbl_main.Controls.Add(this.lbl_warning, 0, 0);
			this.tbl_main.Controls.Add(this.num_amount, 1, 1);
			this.tbl_main.Controls.Add(this.lbl_amount, 0, 1);
			this.tbl_main.Controls.Add(this.tbl_latitude, 1, 2);
			this.tbl_main.Controls.Add(this.tbl_longitude, 1, 3);
			this.tbl_main.Controls.Add(this.lbl_latitude, 0, 2);
			this.tbl_main.Controls.Add(this.lbl_longitude, 0, 3);
			this.tbl_main.Dock = System.Windows.Forms.DockStyle.Fill;
			this.tbl_main.Location = new System.Drawing.Point(0, 0);
			this.tbl_main.Name = "tbl_main";
			this.tbl_main.RowCount = 5;
			this.tbl_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
			this.tbl_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.tbl_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.tbl_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 24F));
			this.tbl_main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 28F));
			this.tbl_main.Size = new System.Drawing.Size(294, 200);
			this.tbl_main.TabIndex = 3;
			// 
			// tbl_buttons
			// 
			this.tbl_buttons.ColumnCount = 2;
			this.tbl_buttons.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.tbl_buttons.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.tbl_buttons.Controls.Add(this.btn_ok, 0, 0);
			this.tbl_buttons.Controls.Add(this.btn_cancel, 1, 0);
			this.tbl_buttons.Dock = System.Windows.Forms.DockStyle.Fill;
			this.tbl_buttons.Location = new System.Drawing.Point(75, 172);
			this.tbl_buttons.Margin = new System.Windows.Forms.Padding(0);
			this.tbl_buttons.Name = "tbl_buttons";
			this.tbl_buttons.RowCount = 1;
			this.tbl_buttons.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.tbl_buttons.Size = new System.Drawing.Size(219, 28);
			this.tbl_buttons.TabIndex = 4;
			// 
			// btn_cancel
			// 
			this.btn_cancel.Dock = System.Windows.Forms.DockStyle.Fill;
			this.btn_cancel.Location = new System.Drawing.Point(112, 3);
			this.btn_cancel.Name = "btn_cancel";
			this.btn_cancel.Size = new System.Drawing.Size(104, 22);
			this.btn_cancel.TabIndex = 2;
			this.btn_cancel.Text = "Cancel";
			this.btn_cancel.UseVisualStyleBackColor = true;
			this.btn_cancel.Click += new System.EventHandler(this.btn_cancel_Click);
			// 
			// lbl_amount
			// 
			this.lbl_amount.AutoSize = true;
			this.lbl_amount.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_amount.Location = new System.Drawing.Point(3, 100);
			this.lbl_amount.Name = "lbl_amount";
			this.lbl_amount.Size = new System.Drawing.Size(69, 24);
			this.lbl_amount.TabIndex = 3;
			this.lbl_amount.Text = "Amount";
			this.lbl_amount.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// tbl_latitude
			// 
			this.tbl_latitude.ColumnCount = 2;
			this.tbl_latitude.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.tbl_latitude.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.tbl_latitude.Controls.Add(this.num_latmin, 0, 0);
			this.tbl_latitude.Controls.Add(this.num_latmax, 1, 0);
			this.tbl_latitude.Dock = System.Windows.Forms.DockStyle.Fill;
			this.tbl_latitude.Location = new System.Drawing.Point(75, 124);
			this.tbl_latitude.Margin = new System.Windows.Forms.Padding(0);
			this.tbl_latitude.Name = "tbl_latitude";
			this.tbl_latitude.RowCount = 1;
			this.tbl_latitude.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.tbl_latitude.Size = new System.Drawing.Size(219, 24);
			this.tbl_latitude.TabIndex = 5;
			// 
			// num_latmin
			// 
			this.num_latmin.DecimalPlaces = 8;
			this.num_latmin.Dock = System.Windows.Forms.DockStyle.Fill;
			this.num_latmin.Location = new System.Drawing.Point(3, 3);
			this.num_latmin.Maximum = new decimal(new int[] {
            10000,
            0,
            0,
            0});
			this.num_latmin.Minimum = new decimal(new int[] {
            10000,
            0,
            0,
            -2147483648});
			this.num_latmin.Name = "num_latmin";
			this.num_latmin.Size = new System.Drawing.Size(103, 20);
			this.num_latmin.TabIndex = 0;
			this.num_latmin.Value = new decimal(new int[] {
            55,
            0,
            0,
            0});
			// 
			// num_latmax
			// 
			this.num_latmax.DecimalPlaces = 8;
			this.num_latmax.Dock = System.Windows.Forms.DockStyle.Fill;
			this.num_latmax.Location = new System.Drawing.Point(112, 3);
			this.num_latmax.Maximum = new decimal(new int[] {
            10000,
            0,
            0,
            0});
			this.num_latmax.Minimum = new decimal(new int[] {
            10000,
            0,
            0,
            -2147483648});
			this.num_latmax.Name = "num_latmax";
			this.num_latmax.Size = new System.Drawing.Size(104, 20);
			this.num_latmax.TabIndex = 1;
			this.num_latmax.Value = new decimal(new int[] {
            56,
            0,
            0,
            0});
			// 
			// tbl_longitude
			// 
			this.tbl_longitude.ColumnCount = 2;
			this.tbl_longitude.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.tbl_longitude.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.tbl_longitude.Controls.Add(this.num_lonmin, 0, 0);
			this.tbl_longitude.Controls.Add(this.num_lonmax, 1, 0);
			this.tbl_longitude.Dock = System.Windows.Forms.DockStyle.Fill;
			this.tbl_longitude.Location = new System.Drawing.Point(75, 148);
			this.tbl_longitude.Margin = new System.Windows.Forms.Padding(0);
			this.tbl_longitude.Name = "tbl_longitude";
			this.tbl_longitude.RowCount = 1;
			this.tbl_longitude.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
			this.tbl_longitude.Size = new System.Drawing.Size(219, 24);
			this.tbl_longitude.TabIndex = 6;
			// 
			// num_lonmin
			// 
			this.num_lonmin.DecimalPlaces = 8;
			this.num_lonmin.Dock = System.Windows.Forms.DockStyle.Fill;
			this.num_lonmin.Location = new System.Drawing.Point(3, 3);
			this.num_lonmin.Maximum = new decimal(new int[] {
            10000,
            0,
            0,
            0});
			this.num_lonmin.Minimum = new decimal(new int[] {
            10000,
            0,
            0,
            -2147483648});
			this.num_lonmin.Name = "num_lonmin";
			this.num_lonmin.Size = new System.Drawing.Size(103, 20);
			this.num_lonmin.TabIndex = 0;
			this.num_lonmin.Value = new decimal(new int[] {
            11,
            0,
            0,
            0});
			// 
			// num_lonmax
			// 
			this.num_lonmax.DecimalPlaces = 8;
			this.num_lonmax.Dock = System.Windows.Forms.DockStyle.Fill;
			this.num_lonmax.Location = new System.Drawing.Point(112, 3);
			this.num_lonmax.Maximum = new decimal(new int[] {
            10000,
            0,
            0,
            0});
			this.num_lonmax.Minimum = new decimal(new int[] {
            10000,
            0,
            0,
            -2147483648});
			this.num_lonmax.Name = "num_lonmax";
			this.num_lonmax.Size = new System.Drawing.Size(104, 20);
			this.num_lonmax.TabIndex = 1;
			this.num_lonmax.Value = new decimal(new int[] {
            12,
            0,
            0,
            0});
			// 
			// lbl_latitude
			// 
			this.lbl_latitude.AutoSize = true;
			this.lbl_latitude.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_latitude.Location = new System.Drawing.Point(3, 124);
			this.lbl_latitude.Name = "lbl_latitude";
			this.lbl_latitude.Size = new System.Drawing.Size(69, 24);
			this.lbl_latitude.TabIndex = 7;
			this.lbl_latitude.Text = "Latitude";
			this.lbl_latitude.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lbl_longitude
			// 
			this.lbl_longitude.AutoSize = true;
			this.lbl_longitude.Dock = System.Windows.Forms.DockStyle.Fill;
			this.lbl_longitude.Location = new System.Drawing.Point(3, 148);
			this.lbl_longitude.Name = "lbl_longitude";
			this.lbl_longitude.Size = new System.Drawing.Size(69, 24);
			this.lbl_longitude.TabIndex = 8;
			this.lbl_longitude.Text = "longitude";
			this.lbl_longitude.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// RandomForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(294, 200);
			this.Controls.Add(this.tbl_main);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
			this.Name = "RandomForm";
			this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Hide;
			this.Text = "Create Random Users";
			((System.ComponentModel.ISupportInitialize)(this.num_amount)).EndInit();
			this.tbl_main.ResumeLayout(false);
			this.tbl_main.PerformLayout();
			this.tbl_buttons.ResumeLayout(false);
			this.tbl_latitude.ResumeLayout(false);
			((System.ComponentModel.ISupportInitialize)(this.num_latmin)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.num_latmax)).EndInit();
			this.tbl_longitude.ResumeLayout(false);
			((System.ComponentModel.ISupportInitialize)(this.num_lonmin)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.num_lonmax)).EndInit();
			this.ResumeLayout(false);

		}

		#endregion

		private System.Windows.Forms.NumericUpDown num_amount;
		private System.Windows.Forms.Button btn_ok;
		private System.Windows.Forms.Label lbl_warning;
		private System.Windows.Forms.TableLayoutPanel tbl_main;
		private System.Windows.Forms.TableLayoutPanel tbl_buttons;
		private System.Windows.Forms.Button btn_cancel;
		private System.Windows.Forms.Label lbl_amount;
		private System.Windows.Forms.TableLayoutPanel tbl_latitude;
		private System.Windows.Forms.NumericUpDown num_latmin;
		private System.Windows.Forms.NumericUpDown num_latmax;
		private System.Windows.Forms.TableLayoutPanel tbl_longitude;
		private System.Windows.Forms.NumericUpDown num_lonmin;
		private System.Windows.Forms.NumericUpDown num_lonmax;
		private System.Windows.Forms.Label lbl_latitude;
		private System.Windows.Forms.Label lbl_longitude;
	}
}