#ifndef BASE_H
#define BASE_H

#include <string>
#include "iterator.hpp"
#include "visitor.hpp"


class Base {
    public:
        /* Constructors */
        Base() { };

        /* Pure Virtual Functions */
        virtual double evaluate() = 0;
        virtual Base* get_left() = 0;
        virtual Base* get_right() = 0;
        virtual std::string stringify() = 0;
        Iterator* create_iterator() {};
        virtual void accept(CountVisitor*) = 0;
};

#endif
