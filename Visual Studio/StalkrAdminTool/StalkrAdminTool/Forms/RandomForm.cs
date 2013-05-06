using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace StalkrAdminTool
{
	public partial class RandomForm : Form
	{
		private static string[] USERNAMES = { "test", "Test", "TEST", "notarealuser", "NOTREAL", "notreal" };
		private static string[] FIRSTNAMES = {	"Allan", "Alice", "Amanda", "Anastasia", "Arnold",
												"Bob", "Bobby", "Bonnie", "Ben", "Benjamin",
												"Catherine", "Carmen", "Charlie", "Charles", "Chang",
												"John", "Jake", "Jessy", "Jasmin", "Jonas",
												"Kurt", "Kary", "Kirsten", "Karl", "Katy",
												"Logan", "Lilly", "Lisa", "Ling", "Lars",
												"Peter", "Philip", "Pedro", "Poul", "Pouline",
												"Richard", "Robert", "Rob", "Ralph", "Ronnie",
												"Stephanie", "Stefan", "Sergeis", "Sabine", "Saddam" };
		private static string[] LASTNAMES = {	"Hyde", "Hugenstuf", "Schwarzenegger", "Singer", "Bennet",
												"Franklin", "Pierce", "Electra", "Sheen", "Darwin",
												"Tran", "Doe", "Sullivan", "Jamesson", "Chang",
												"Douglas", "Byron", "Dunst", "Pilkington", "Middleton",
												"Lourne", "Simpson", "Andersen", "Parker", "Rodrigues",
												"Phoenix", "Meyers", "Hammond", "Haddock", "Schneider",
												"Wiggum", "Gilbert", "Hussein", "Wilks", "Booth" };

		private WSconnect _db;
		private Random _rng;

		public RandomForm()
		{
			InitializeComponent();

			_db = WSconnect.Instance;
			_rng = new Random(DateTime.Now.Second * (int)(Tools.DTtoTS(DateTime.Now) / 1000));
		}

		private string GenerateUsername(Guid id)
		{
			return USERNAMES[_rng.Next(USERNAMES.Length - 1)] +
					id.ToString().Substring(0, 8);
		}
		private string GenerateEmail(string username)
		{
			return username + "@iensenfirippu.dk";
		}
		private string GenerateFirstname()
		{
			string result = "";
			if (_rng.Next(0, 100) == 42)
			{
				result += FIRSTNAMES[_rng.Next(FIRSTNAMES.Length - 1)] + "-";
			}
			return result += FIRSTNAMES[_rng.Next(FIRSTNAMES.Length - 1)];
		}
		private string GenerateLastname()
		{
			string result = "";
			if (_rng.Next(0, 100) == 42)
			{
				result += LASTNAMES[_rng.Next(LASTNAMES.Length - 1)] + "-";
			}
			return result += LASTNAMES[_rng.Next(LASTNAMES.Length - 1)];
		}
		private string GenerateBinaryString(int maxones, int length)
		{
			string result = "";
			for (int i = 0; i < length; i++)
			{
				if (maxones > 0 && (_rng.Next(0, 100) % 2) == 1)
				{
					result += "1";
					maxones--;
				}
				else
				{
					result += "0";
				}
			}
			return result;
		}

		private void btn_ok_Click(object sender, EventArgs e)
		{
			long now = Tools.DTtoTS(DateTime.Now);

			for (int i = 0; i < num_amount.Value; i++)
			{
				User user = new User();

				//user.UniqueID;
				user.Username = GenerateUsername(user.UniqueID);
				user.Password = "test1234";
				user.Email = GenerateEmail(user.Username);
				user.FirstName = GenerateFirstname();
				user.LastName = GenerateLastname();
				user.Birthday = Tools.DTfromTS(now - (_rng.Next(18, 80) * _rng.Next(30758400, 31000000)));

				user.Location = new GeoLocation(	Convert.ToSingle((_rng.NextDouble() * (double)(num_latmax.Value - num_latmin.Value)) + (double)num_latmin.Value),
													Convert.ToSingle((_rng.NextDouble() * (double)(num_lonmax.Value - num_lonmin.Value)) + (double)num_lonmin.Value));
				
				user.Description = new Description();
				//user.Description.UniqueID;
				user.Description.TimeStamp = DateTime.Now;
				user.Description.Title = "Description";
				user.Description.SetAge(_rng.Next(18, 99));
				user.Description.Gender = EnumList<GenderType>.FromString(GenerateBinaryString(1, 5));
				user.Description.Sexuality = EnumList<SexualityType>.FromString(GenerateBinaryString(1, 4));
				user.Description.Area = EnumList<AreaType>.FromString(GenerateBinaryString(1, 5));
				user.Description.Smoking = EnumList<SmokingType>.FromString(GenerateBinaryString(1, 3));
				user.Description.Drinking = EnumList<DrinkingType>.FromString(GenerateBinaryString(1, 2));

				Description p = new Description();
				//user.Description.UniqueID;
				p.TimeStamp = DateTime.Now;
				p.Title = "pref" + _rng.Next(1, 9999).ToString("0000");
				p.SetAge(_rng.Next(18, 99), _rng.Next(18, 99));
				p.Gender = EnumList<GenderType>.FromString(GenerateBinaryString(5, 5));
				p.Sexuality = EnumList<SexualityType>.FromString(GenerateBinaryString(4, 4));
				p.Area = EnumList<AreaType>.FromString(GenerateBinaryString(5, 5));
				p.Smoking = EnumList<SmokingType>.FromString(GenerateBinaryString(3, 3));
				p.Drinking = EnumList<DrinkingType>.FromString(GenerateBinaryString(2, 2));
				user.Preferences.Add(p);

				string result = _db.SaveUser(user);

				if (!result.Equals("E10"))
				{
					MessageBox.Show("Couldn't save user at iteration (Errorcode: " + result + ") " + (i+1), "Error", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
				}
			}

			Close();
		}

		private void btn_cancel_Click(object sender, EventArgs e)
		{
			Close();
		}
	}
}
