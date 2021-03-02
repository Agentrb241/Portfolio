#ifndef RAND_H
#define RAND_H

#include<string>
#include<iostream>
#include<ctime>
#include<cstdlib>
#include "base.h"
#include "iterator.hpp"

class Rand : public Base {
protected:
double val;
public:
Rand();
double evaluate();
std::string stringify();
        Base* get_left();
        Base* get_right();
        Iterator* create_iterator();
        void accept(CountVisitor* visitor);
};
#endif
