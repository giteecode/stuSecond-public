// http://eslint.org/docs/user-guide/configuring

module.exports = {
  root: true,
  parser: "babel-eslint",
  parserOptions: {
    sourceType: "module"
  },
  env: {
    browser: true
  },
  // https://github.com/feross/standard/blob/master/RULES.md#javascript-standard-style
  extends: ["plugin:vue/recommended"],
  // required to lint *.vue files
  plugins: ["Vue"],
  // add your custom rules here
  rules: {
    // allow paren-less arrow functions
    "arrow-parens": 0,
    // allow async-await
    "generator-star-spacing": 0,
    // allow debugger during development
    "no-debugger": process.env.NODE_ENV === "production" ? 2 : 0,
    "no-trailing-spaces": 1,
    quotes: "off",
    semi: "off",
    "comma-dangle": "off"
  }
};
// module.exports = {
//   extends: ["plugin:vue/recommended"]
// };
