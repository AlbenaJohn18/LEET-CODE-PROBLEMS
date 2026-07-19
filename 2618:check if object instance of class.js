/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    // classFunction must actually be a function/class
    if (typeof classFunction !== 'function') return false;
    
    // Handle primitives by boxing them, since primitives can't have a prototype chain lookup directly
    if (obj === null || obj === undefined) return false;
    
    let proto = Object(obj);
    
    return proto instanceof classFunction;
};
