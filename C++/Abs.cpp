#include "Abs.h"
#include <cmath>
Absolute::Absolute(Base* x) {
this->child = x;
}
std::string Absolute::stringify() {
        if (child) {
                return  child->stringify();
        }
        else {
                throw "No base set!";
        }
}
double Absolute::evaluate() {
return abs(child->evaluate());
}
