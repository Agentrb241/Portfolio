#ifndef POW_H
#define POW_H

#include "base.h"
#include <string>
#include <sstream>
#include <cmath>
#include "iterator.hpp"

class Pow : public Base {
public:
        Pow();
        Pow(Base *left, Base *right);
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
