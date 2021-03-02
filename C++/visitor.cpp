#include "visitor.hpp"
        void CountVisitor::visit_op() {
                ops += 1;
        }
        int CountVisitor::op_count(){
        return this->ops;}
        void CountVisitor::visit_rand(){
        rands += 1;}
        int CountVisitor::rand_count(){
        return this->rands;}
        void CountVisitor::visit_mult(){
        mults +=1;}
        int CountVisitor::mult_count(){
        return this->mults;}
        void CountVisitor::visit_div(){
        divs += 1;}
        int CountVisitor::div_count(){
        return this->divs;}
        void CountVisitor::visit_add(){
        add += 1;}
        int CountVisitor::add_count(){
        return this->add;}
//        void CountVisitor::visit_sub(){
  //      sub += 1;}
//        int CountVisitor::sub_count(){
  //      return this->sub;}
        void CountVisitor::visit_pow(){
        pow += 1;}
        int CountVisitor::pow_count(){
        return this->pow;}

        void CountVisitor::visit_ceil(){
        ceil += 1;}
        int CountVisitor::ceil_count(){
        return this->ceil;}
        void CountVisitor::visit_floor(){
        floor += 1;}
        int CountVisitor::floor_count(){
        return this->floor;}
        void CountVisitor::visit_abs(){
        abs += 1;}
        int CountVisitor::abs_count(){
        return this->abs;}
        void CountVisitor::visit_trunc(){
        trunc += 1;}
        int CountVisitor::trunc_count(){
        return this->trunc;}
        void CountVisitor::visit_paren(){
        paren += 1;}
        int CountVisitor::paren_count() {
        return this->paren;}
