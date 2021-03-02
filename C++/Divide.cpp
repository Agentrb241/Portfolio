#include "Divide.h"

Divide::Divide() {

}

Divide::Divide(Base *left, Base *right) {
        this->left = left;
        this->right = right;
}

double Divide::evaluate() {
        return left->evaluate() / right->evaluate();
}

std::string Divide::stringify() {
        std::stringstream ss;
        ss << left->stringify() << " / " << right->stringify();
        return ss.str();
}
Base* Divide::get_left() {
        return left;
}

Base* Divide::get_right() {
        return right;
}

Iterator* Divide::create_iterator() {
        return new BinaryIterator(this);
}

void Divide::accept(CountVisitor* visitor) {
        visitor->visit_div();
}


