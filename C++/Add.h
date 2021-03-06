#ifndef ADD_H
#define ADD_H

#include "base.h"
#include <string>
#include <sstream>
#include "iterator.hpp"

class Add : public Base {
public:
        Add();
        Add(Base *left, Base *right);
        double evaluate();
        std::string stringify();
	Base* get_left();
        Base* get_right();
        Iterator* create_iterator();
        void accept(CountVisitor* visitor);
private:
        Base *left;
        Base *right;
};

#endif
