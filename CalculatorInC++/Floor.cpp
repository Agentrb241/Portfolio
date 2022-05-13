#include "Floor.h"
#include <cmath>
Floor::Floor(Base* x) {
this->child = x;
}
std::string Floor::stringify() {
        if (child) {
                return  child->stringify();
        }
        else {
                throw "No base set!";
        }
}
double Floor::evaluate() {
return floor(child->evaluate());
}


