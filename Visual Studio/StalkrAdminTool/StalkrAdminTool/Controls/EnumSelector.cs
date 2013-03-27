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
		private static string FONTFAMILY = "Arial";
		private static float FONTSIZE = 8;

		private List<string> _values;
		private List<string> _checkedvalues;
		private Boolean _ispreference;

		public EnumSelector()
		{
			InitializeComponent();
		}

		public void SetValues(List<string> values, List<string> checkedvalues, Boolean ispreference)
		{
			_values = values;
			_checkedvalues = checkedvalues;
			_ispreference = ispreference;
			Font font = new System.Drawing.Font(new FontFamily(FONTFAMILY), FONTSIZE);

			flowLayoutPanel1.Controls.Clear();
			if (_ispreference)
			{
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
			else
			{
				for (int i = 0; i < _values.Count; i++)
				{
					RadioButton rad = new RadioButton();
					rad.Font = font;
					if (CHECKBOXWIDTH >= 0) { rad.Width = CHECKBOXWIDTH; }
					if (CHECKBOXHEIGTH >= 0) { rad.Height = CHECKBOXHEIGTH; }
					rad.Margin = new Padding(0);

					rad.Name = _values[i];
					rad.Text = _values[i];
					if (_checkedvalues.Contains(_values[i])) { rad.Checked = true; }
					rad.CheckedChanged += new System.EventHandler(this.Checkbox_CheckedChanged);
					flowLayoutPanel1.Controls.Add(rad);
				}
			}
		}

		private void Checkbox_CheckedChanged(object sender, EventArgs e)
		{
			List<string> checkedvaluesnew = new List<string>();

			if (_ispreference)
			{
				foreach (CheckBox chk in flowLayoutPanel1.Controls)
				{
					if (chk.Checked == true)
					{
						checkedvaluesnew.Add(chk.Name);
					}
				}
			}
			else
			{
				foreach (RadioButton rad in flowLayoutPanel1.Controls)
				{
					if (rad.Checked == true)
					{
						checkedvaluesnew.Add(rad.Name);
					}
				}
			}

			_checkedvalues = checkedvaluesnew;
		}

		public List<string> Value
		{
			get { return _checkedvalues; }
		}
	}
}
