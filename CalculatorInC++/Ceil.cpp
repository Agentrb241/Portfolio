#include "Ceil.h"
#include <cmath>
Ceil::Ceil(Base* x) {
this->child = x;
}
std::string Ceil::stringify() {
        if (child) {
                return  child->stringify();
        }
        else {
                throw "No base set!";
        }
}
double Ceil::evaluate() {
return ceil(child->evaluate());
}
