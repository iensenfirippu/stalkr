using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace StalkrAdminTool.Controls
{
	public partial class EnumSelector : UserControl
	{
		private static int CHECKBOXWIDTH = 88;
		private static int CHECKBOXHEIGTH = 20;
		private static float FONTSIZE = 8;

		private List<string> _values;
		private List<string> _checkedvalues;

		public EnumSelector()
		{
			InitializeComponent();
		}

		public void SetValues(List<string> values, List<string> checkedvalues)
		{
			_values = values;
			_checkedvalues = checkedvalues;
			Font font = new System.Drawing.Font(new FontFamily("Arial"), FONTSIZE);

			flowLayoutPanel1.Controls.Clear();
			for (int i = 0; i < _values.Count; i++)
			{
				CheckBox chk = new CheckBox();
				chk.Font = font;
				if (CHECKBOXWIDTH >= 0) { chk.Width = CHECKBOXWIDTH; }
				if (CHECKBOXHEIGTH >= 0) { chk.Height = CHECKBOXHEIGTH; }
				chk.Margin = new Padding(0);

				chk.Name = _values[i];
				chk.Text = _values[i];
				if (_checkedvalues.Contains(_values[i])) { chk.Checked = true; }
				chk.CheckedChanged += new System.EventHandler(this.Checkbox_CheckedChanged);
				flowLayoutPanel1.Controls.Add(chk);
			}
		}

		private void Checkbox_CheckedChanged(object sender, EventArgs e)
		{
			List<string> checkedvaluesnew = new List<string>();

			foreach (CheckBox chk in flowLayoutPanel1.Controls)
			{
				checkedvaluesnew.Add(chk.Name);
			}

			_checkedvalues = checkedvaluesnew;
		}
	}
}
