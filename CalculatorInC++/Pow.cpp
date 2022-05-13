#include "Pow.h"

Pow::Pow() {

}

Pow::Pow(Base *left, Base *right) {
        this->left = left;
        this->right = right;
}

double Pow::evaluate() {
        return std::pow(left->evaluate(), right->evaluate());
}

std::string Pow::stringify() {
        std::stringstream ss;
        ss << left->stringify() << " ** " << right->stringify();
        return ss.str();
}
Base* Pow::get_left() {
        return left;
}

Base* Pow::get_right() {
        return right;
}

Iterator* Pow::create_iterator() {
        return new BinaryIterator(this);
}

void Pow::accept(CountVisitor* visitor) {
        visitor->visit_pow();
}

