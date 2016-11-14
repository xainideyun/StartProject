using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace FileUpload.Models
{
    public class User
    {
        public string Name { get; set; } = "孙小双";
        public int Age { get; set; } = 28;
        public string Code { get; set; } = "sunxsh";
        public string FilePath { get; set; }
    }
}