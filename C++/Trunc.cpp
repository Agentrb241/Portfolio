#include "Trunc.h"

Trunc::Trunc() {

}

Trunc::Trunc(Base* base) {
        child = base;
}

double Trunc::evaluate() {
        if (child) {
                return child->evaluate();
        }
        else {
                throw "No base set!";
        }
}

std::string Trunc::stringify() {
        if (child) {
                Op* eval = new Op(child->evaluate());
                return eval->stringify();
        }
        else {
                throw "No base set!";
        }
}
