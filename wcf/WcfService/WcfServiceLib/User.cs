﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WcfServiceLib
{
    // 注意: 使用“重构”菜单上的“重命名”命令，可以同时更改代码和配置文件中的类名“User”。
    public class User : IUser
    {
        public void GetEmail()
        {
            Console.WriteLine("sunxsaljj@163.com");
        }

        public string GetName()
        {
            return "李娟娟+孙小双";
        }
    }
}
