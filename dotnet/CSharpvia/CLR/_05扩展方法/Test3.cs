using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05扩展方法
{
    public delegate Test3 MyHandler(string name = "孙小双", int age = 28, Test3 t = Test3.T3);
    public sealed partial class Test3
    {
        partial void OnNameChange();
        private string _name;
        public string Name {
            get
            {
                return _name;
            }
            set
            {
                OnNameChange();
                _name = value;
            }
        }
        public int Count { get; set; }

        public const Test3 T3 = null;
    }
}
