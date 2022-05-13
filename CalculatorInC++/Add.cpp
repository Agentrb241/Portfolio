#include "Add.h"

Add::Add() {

}

Add::Add(Base *left, Base *right) {
        this->left = left;
        this->right = right;
}

double Add::evaluate() {
        return left->evaluate() + right->evaluate();
}

std::string Add::stringify() {
        std::stringstream ss;
        ss << left->stringify() << " + " << right->stringify();
        return ss.str();
}
Base* Add::get_left() {
        return left;
}

Base* Add::get_right() {
        return right;
}

Iterator* Add::create_iterator() {
        return new BinaryIterator(this);
}

void Add::accept(CountVisitor* visitor) {
        visitor->visit_add();
}

