#include "Dummy.h"

Dummy::Dummy() {}

Dummy::Dummy(Base* child) {
        this->child = child;
}
double Dummy::evaluate() {
        return 0;
}

std::string Dummy::stringify() {
        return "";
}

Base* Dummy::get_left() {
        return child;
}

Base* Dummy::get_right() {
        return nullptr;
}

Iterator* Dummy::create_iterator() {
        return new UnaryIterator(this);
}

void Dummy::accept(CountVisitor* visitor) {}
