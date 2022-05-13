#include "Rand.h"

Rand::Rand() {
        srand(time(0));
        val  = rand();
}

double Rand::evaluate() {
        return val;
}

std::string Rand::stringify() {
        return std::to_string(val);
}
Base* Rand::get_left() {
        return nullptr;
}

Base* Rand::get_right() {
        return nullptr;
}

Iterator* Rand::create_iterator() {
        return new NullIterator(this);
}

void Rand::accept(CountVisitor* visitor) {
        visitor->visit_rand();
}
