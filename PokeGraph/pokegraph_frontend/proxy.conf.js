const PROXY_CONFIG = [
  {
    context: ['/api'],
    target: 'http://localhost:9090/pokemon',
    secure: false,
    logLevel: 'debug',
    pathRewrite: { '^/api': ''}
  }
]

module.exports = PROXY_CONFIG;
