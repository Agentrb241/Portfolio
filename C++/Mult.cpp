#include "Mult.h"

Mult::Mult() {

}

Mult::Mult(Base *left, Base *right) {
        this->left = left;
        this->right = right;
}

double Mult::evaluate() {
        return left->evaluate() * right->evaluate();
}

std::string Mult::stringify() {
        return left->stringify() + " * " + right->stringify();
}
Base* Mult::get_left() {
        return left;
}

Base* Mult::get_right() {
        return right;
}

Iterator* Mult::create_iterator() {
        return new BinaryIterator(this);
}

void Mult::accept(CountVisitor* visitor) {
        visitor->visit_mult();
}

