using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05扩展方法
{
    public sealed partial class Test3
    {
        partial void OnNameChange()
        {
            Count++;
        }
    }
}
