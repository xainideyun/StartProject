using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace _08属性
{
    public class Student
    {
        private List<string> _study;
        [IndexerName("study")]
        public string this[int key]
        {
            get
            {
                return _study[key];
            }
        }
    }
}
