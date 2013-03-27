namespace StalkrAdminTool
{
	partial class MainForm
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
			this.components = new System.ComponentModel.Container();
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainForm));
			this.menu_main = new System.Windows.Forms.MenuStrip();
			this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.aboutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.aboutToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
			this.status_main = new System.Windows.Forms.StatusStrip();
			this.status_label = new System.Windows.Forms.ToolStripStatusLabel();
			this.dgv_main = new System.Windows.Forms.DataGridView();
			this.context_gridview = new System.Windows.Forms.ContextMenuStrip(this.components);
			this.createNewUserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.deleteThisUserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.editThisUserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.status_timer = new System.Windows.Forms.Timer(this.components);
			this.menu_main.SuspendLayout();
			this.status_main.SuspendLayout();
			((System.ComponentModel.ISupportInitialize)(this.dgv_main)).BeginInit();
			this.context_gridview.SuspendLayout();
			this.SuspendLayout();
			// 
			// menu_main
			// 
			this.menu_main.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.aboutToolStripMenuItem});
			this.menu_main.Location = new System.Drawing.Point(0, 0);
			this.menu_main.Name = "menu_main";
			this.menu_main.Size = new System.Drawing.Size(292, 24);
			this.menu_main.TabIndex = 1;
			this.menu_main.Text = "menuStrip1";
			// 
			// fileToolStripMenuItem
			// 
			this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.exitToolStripMenuItem});
			this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
			this.fileToolStripMenuItem.Size = new System.Drawing.Size(35, 20);
			this.fileToolStripMenuItem.Text = "File";
			// 
			// exitToolStripMenuItem
			// 
			this.exitToolStripMenuItem.Image = global::StalkrAdminTool.Properties.Resources.exit;
			this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
			this.exitToolStripMenuItem.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Alt | System.Windows.Forms.Keys.F4)));
			this.exitToolStripMenuItem.Size = new System.Drawing.Size(132, 22);
			this.exitToolStripMenuItem.Text = "Exit";
			this.exitToolStripMenuItem.Click += new System.EventHandler(this.exitToolStripMenuItem_Click);
			// 
			// aboutToolStripMenuItem
			// 
			this.aboutToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.aboutToolStripMenuItem1});
			this.aboutToolStripMenuItem.Name = "aboutToolStripMenuItem";
			this.aboutToolStripMenuItem.Size = new System.Drawing.Size(40, 20);
			this.aboutToolStripMenuItem.Text = "Help";
			// 
			// aboutToolStripMenuItem1
			// 
			this.aboutToolStripMenuItem1.Image = global::StalkrAdminTool.Properties.Resources.information;
			this.aboutToolStripMenuItem1.Name = "aboutToolStripMenuItem1";
			this.aboutToolStripMenuItem1.Size = new System.Drawing.Size(103, 22);
			this.aboutToolStripMenuItem1.Text = "About";
			this.aboutToolStripMenuItem1.Click += new System.EventHandler(this.aboutToolStripMenuItem1_Click);
			// 
			// status_main
			// 
			this.status_main.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.status_label});
			this.status_main.Location = new System.Drawing.Point(0, 251);
			this.status_main.Name = "status_main";
			this.status_main.Size = new System.Drawing.Size(292, 22);
			this.status_main.TabIndex = 1;
			this.status_main.Text = "statusStrip1";
			// 
			// status_label
			// 
			this.status_label.Name = "status_label";
			this.status_label.Size = new System.Drawing.Size(109, 17);
			this.status_label.Text = "toolStripStatusLabel1";
			this.status_label.TextChanged += new System.EventHandler(this.status_label_TextChanged);
			// 
			// dgv_main
			// 
			this.dgv_main.AllowUserToAddRows = false;
			this.dgv_main.AllowUserToDeleteRows = false;
			this.dgv_main.AllowUserToResizeRows = false;
			this.dgv_main.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
			this.dgv_main.Dock = System.Windows.Forms.DockStyle.Fill;
			this.dgv_main.EditMode = System.Windows.Forms.DataGridViewEditMode.EditProgrammatically;
			this.dgv_main.Location = new System.Drawing.Point(0, 24);
			this.dgv_main.Name = "dgv_main";
			this.dgv_main.RowHeadersVisible = false;
			this.dgv_main.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
			this.dgv_main.Size = new System.Drawing.Size(292, 227);
			this.dgv_main.TabIndex = 2;
			this.dgv_main.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellDoubleClick);
			this.dgv_main.MouseClick += new System.Windows.Forms.MouseEventHandler(this.dataGridView1_MouseClick);
			// 
			// context_gridview
			// 
			this.context_gridview.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.createNewUserToolStripMenuItem,
            this.deleteThisUserToolStripMenuItem,
            this.editThisUserToolStripMenuItem});
			this.context_gridview.Name = "contextMenuStrip1";
			this.context_gridview.Size = new System.Drawing.Size(155, 70);
			// 
			// createNewUserToolStripMenuItem
			// 
			this.createNewUserToolStripMenuItem.Image = global::StalkrAdminTool.Properties.Resources.add2;
			this.createNewUserToolStripMenuItem.Name = "createNewUserToolStripMenuItem";
			this.createNewUserToolStripMenuItem.Size = new System.Drawing.Size(154, 22);
			this.createNewUserToolStripMenuItem.Text = "Create new user";
			this.createNewUserToolStripMenuItem.MouseUp += new System.Windows.Forms.MouseEventHandler(this.createNewUserToolStripMenuItem_MouseUp);
			// 
			// deleteThisUserToolStripMenuItem
			// 
			this.deleteThisUserToolStripMenuItem.Image = global::StalkrAdminTool.Properties.Resources.delete2;
			this.deleteThisUserToolStripMenuItem.Name = "deleteThisUserToolStripMenuItem";
			this.deleteThisUserToolStripMenuItem.Size = new System.Drawing.Size(154, 22);
			this.deleteThisUserToolStripMenuItem.Text = "Delete this user";
			this.deleteThisUserToolStripMenuItem.MouseUp += new System.Windows.Forms.MouseEventHandler(this.deleteThisUserToolStripMenuItem_MouseUp);
			// 
			// editThisUserToolStripMenuItem
			// 
			this.editThisUserToolStripMenuItem.Image = global::StalkrAdminTool.Properties.Resources.edit;
			this.editThisUserToolStripMenuItem.Name = "editThisUserToolStripMenuItem";
			this.editThisUserToolStripMenuItem.Size = new System.Drawing.Size(154, 22);
			this.editThisUserToolStripMenuItem.Text = "Edit this user";
			this.editThisUserToolStripMenuItem.MouseUp += new System.Windows.Forms.MouseEventHandler(this.editThisUserToolStripMenuItem_MouseUp);
			// 
			// status_timer
			// 
			this.status_timer.Interval = 10000;
			this.status_timer.Tick += new System.EventHandler(this.status_timer_Tick);
			// 
			// MainForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(292, 273);
			this.Controls.Add(this.dgv_main);
			this.Controls.Add(this.status_main);
			this.Controls.Add(this.menu_main);
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.MainMenuStrip = this.menu_main;
			this.Name = "MainForm";
			this.Text = "Stalkr Admin Tool - Main window";
			this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
			this.menu_main.ResumeLayout(false);
			this.menu_main.PerformLayout();
			this.status_main.ResumeLayout(false);
			this.status_main.PerformLayout();
			((System.ComponentModel.ISupportInitialize)(this.dgv_main)).EndInit();
			this.context_gridview.ResumeLayout(false);
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.MenuStrip menu_main;
		private System.Windows.Forms.StatusStrip status_main;
		private System.Windows.Forms.DataGridView dgv_main;
		private System.Windows.Forms.ContextMenuStrip context_gridview;
		private System.Windows.Forms.ToolStripMenuItem createNewUserToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem deleteThisUserToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem editThisUserToolStripMenuItem;
		private System.Windows.Forms.ToolStripStatusLabel status_label;
		private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem aboutToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem aboutToolStripMenuItem1;
		private System.Windows.Forms.Timer status_timer;
	}
}

