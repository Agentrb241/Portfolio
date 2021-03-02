#ifndef DUMMY_H
#define DUMMY_H

#include<string>
#include<iostream>
#include "base.h"
#include "iterator.hpp"

class Dummy : public Base {
        protected:
                Base* child;
        public:
                Dummy();
                Dummy(Base* x);
                double evaluate();
                virtual std::string stringify();
                Base* get_left();
                Base* get_right();
                Iterator* create_iterator();
                void accept(CountVisitor* visitor);
};
#endif
