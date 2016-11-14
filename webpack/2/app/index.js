var module1 = require("./module1.js");
document.getElementById("root").appendChild(module1());
document.getElementById("root").appendChild(require("./module2.js")());
require("./style.css");
import React from 'react';
import {render} from 'react-dom';
import Module3 from './module3.js';

render(<Module3 />, document.getElementById('root'));