using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace StalkrAdminTool
{
	static class Program
	{
		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main()
		{
			Application.EnableVisualStyles();
			Application.SetCompatibleTextRenderingDefault(false);
			Application.Run(new MainForm());

			////TESTCODEHERE
			//EnumList<GenderType> gl = EnumList<GenderType>.FromBooleanString("00010");
			//gl.List.Add(GenderType.FEMALE);
			//System.Console.Out.WriteLine(gl.ConvertToBooleanString());
		}
	}
}
