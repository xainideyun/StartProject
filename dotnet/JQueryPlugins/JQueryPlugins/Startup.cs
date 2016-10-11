using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(JQueryPlugins.Startup))]
namespace JQueryPlugins
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
