using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(EFExample.Startup))]
namespace EFExample
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
