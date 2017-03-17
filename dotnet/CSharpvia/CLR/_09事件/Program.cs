using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09事件
{
    public delegate void Abc<T>(object sender, T e);
    public class MailEventArgs : EventArgs
    {
        private string _from, _to, _subject;
        public MailEventArgs(string from, string to, string subject)
        {
            _from = from;
            _to = to;
            _subject = subject;
        }
        public string To { get { return _to; } }
        public string From { get { return _from; } }
        public string Subject { get { return _subject; } }
    }
    class NewMail
    {
        public event Abc<MailEventArgs> NM;
        public void Send(string from, string to, string subject)
        {
            NM(this, new MailEventArgs(from, to, subject));
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            var mail = new NewMail();
            mail.NM += (a, e) =>
            {
                Console.WriteLine(e.From);
                Console.WriteLine(e.To);
                Console.WriteLine(e.Subject);
            };
            mail.Send("孙小双", "李娟娟", "520");
            Console.ReadKey();
        }
    }
}
