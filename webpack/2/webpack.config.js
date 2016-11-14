module.exports = {
	devtool: 'eval-source-map',
	entry: __dirname + '/app/index.js',
	output: {
		path: __dirname + '/public',
		filename: 'bundle.js'
	},
	module: {
		loaders:[
			{test: /\.json$/, loader: "json"},
			{test: /\.css$/, loader: "style!css"},
			{test: /\.js$/, loader: 'babel', query: {presets: ['es2015', 'react']}}
		]
	},
	devServer: {
		contentBase: './public',		// 以public为根目录提供文件
		colors: true,					// 设置终端字体颜色
		historyApiFallback: true,		// 访问服务器上不存在的文件时，都被重定向到/，也就是index.html
		inline: true,					// 文件发生变化时，刷新页面
		port: 8080						// 服务器使用的端口，默认情况为8080
	}
}		