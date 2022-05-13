#include "Op.h"

Op::Op() {
}
Op::Op(double x) {
val = x;
}
double Op::evaluate() {
        return val;
}

std::string Op::stringify() {

        if (val == (int) val) {
                return std::to_string((int) val);
        }
        else {
                std::string valString = std::to_string(val);
                valString.erase(valString.find_last_not_of('0') + 1, std::string::npos);
                return valString;
        }
}
Base* Op::get_left() {
        return nullptr;
}

Base* Op::get_right() {
        return nullptr;
}

Iterator* Op::create_iterator() {
        return new NullIterator(this);
}

void Op::accept(CountVisitor* visitor) {
        visitor->visit_op();
}
