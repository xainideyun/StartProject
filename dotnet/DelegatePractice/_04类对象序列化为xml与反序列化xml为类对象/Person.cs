using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04类对象序列化为xml与反序列化xml为类对象
{
    [Serializable]
    public class Person
    {
        public string Name { get; set; } = "孙小双";
        public int Age { get; set; } = 28;
        public string Code { get; set; } = "2071714117";
        public string School { get; set; } = "新大";
        private List<string> _hobby { get; set; } = new List<string>();
        public List<string> Hobby
        {
            get
            {
                return _hobby;
            }
        }
        public string @Class { get; }
    }
}
