#include "Sub.h"

Sub::Sub() {

}

Sub::Sub(Base *left, Base *right) {
        this->left = left;
        this->right = right;
}

double Sub::evaluate() {
        return left->evaluate() - right->evaluate();
}

std::string Sub::stringify() {
        std::stringstream ss;
        ss << left->stringify() << " - " << right->stringify();
        return ss.str();
}
/*Base* Sub::get_left() {
        return left;
}

Base* Sub::get_right() {
        return right;
}

Iterator* Sub::create_iterator() {
        return new BinaryIterator(this);
}

void Sub::accept(CountVisitor* visitor) {
        visitor->visit_sub();
}
*/
