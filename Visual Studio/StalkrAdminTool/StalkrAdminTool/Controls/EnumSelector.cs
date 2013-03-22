using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace StalkrAdminTool.Controls
{
	public class EnumSelector<T> : DataGridView
	{
		public class NoEnumeratorException : Exception
		{
			private static string MESSAGE = "No enumerator selected, please input only enum types when creating EnumSelector objects.";

			public NoEnumeratorException() : base(MESSAGE) {}
		}

		private T _enumtype;
		private int _enumcolumns;
		private int _enumcolumnwidth;

		public EnumSelector(T type)
		{
			if (type is Enum)
			{
				_enumtype = type;
			}
			
		}

		public T EnumType
		{
			get
			{
				if (_enumtype == null)
				{
					throw new NoEnumeratorException();
				}
				return _enumtype;
			}
		}

		public @override 
	}
}
