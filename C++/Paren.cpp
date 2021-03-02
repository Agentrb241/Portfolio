#include "Paren.h"

Paren::Paren() {

}

Paren::Paren(Base* base) {
        child = base;
}

double Paren::evaluate() {
        if (child) {
                return child->evaluate();
        }
        else {
                throw "No base set!";
        }
}

std::string Paren::stringify() {
        if (child) {
                return "(" + child->stringify() + ")";
        }
        else {
                throw "No base set!";
        }
}
